package IS.EHR_STATUS;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
public class RequestController {

    @Autowired
    public EHR_WORK workrepo;
    @Autowired
    public EHR_STATUS statusrepo;
    @Autowired
    public EHR_ACCESS accessrepo;
    @Autowired
    public EHR_EHR ehrrepo;
    @Autowired
    public EHR_VERSIONED_STATUS versStatusrepo;
    @Autowired
    MongoTemplate mt;
    @Autowired
    @Lazy
    MongoOperations mongoOperation;

    @GetMapping("/getAccess")
    public Access getAccess(@RequestParam String worker, @RequestParam String ehr) {


        Access a = accessrepo.findByWorkerAndEhr(worker, ehr);
        if(a==null){
            a = new Access();
            a.setWorker(worker);
            a.setEhr(ehr);
            a.setAccess("Acesso Proibido");
        }

        switch (a.getAccess()){
            case "0":
                a.setAccess("Acesso Proibido");
                break;
            case "1":
                a.setAccess("Acesso Restrito");
                break;
            case "2":
                a.setAccess("Acesso Limitado");
                break;
            case "3":
                a.setAccess("Acesso Garantido");
                break;
            default:
                break;
        }
        // adicionar tentativa ao access_history
       return a;
    }

    // Esta feito
    @GetMapping("/ehr/{ehr_id}/ehr_status{?version_at_time}")
    public Status getStatus(@PathVariable String ehr_id, @RequestParam(required = false) String version_at_time){

        EHR ehr = ehrrepo.findBy_id(ehr_id);
        System.out.println(ehr);

        Status st = new Status();
        Versioned_Status vs = new Versioned_Status();
        if(version_at_time==null){
            vs = versStatusrepo.findBy_id(ehr.getId_status());
            st = statusrepo.findBy_id(vs.getStatusid().getId().getValue());
        }else {
            vs = versStatusrepo.findByUidValueAndTimecreatedValue(ehr_id, version_at_time);
            st = statusrepo.findBy_id(vs.getStatusid().getId().getValue());
        }

        return st;
    }

    //Esta feito
    @GetMapping("/ehr/{ehr_id}/ehr_status/{uid}")
    public Status getStatusByUId(@PathVariable String ehr_id, @PathVariable String uid){

        Status st = new Status();
        Versioned_Status vs = new Versioned_Status();

        vs = versStatusrepo.findBy_idAndUidValue(uid, ehr_id);
        st = statusrepo.findBy_id(vs.getStatusid().getId().getValue());

        return st;
    }

    // Esta feito
    @GetMapping("/ehr/{ehr_id}/versioned_ehr_status")
    public Status getVersionedStatus(@PathVariable String ehr_id){

        EHR ehr = ehrrepo.findBy_id(ehr_id);

        Versioned_Status vs = versStatusrepo.findBy_id(ehr.getId_status());

        Status status = statusrepo.findBy_id(vs.getStatusid().getId().getValue());

        return status;
    }

    // Esta feito
    @GetMapping("/ehr/{ehr_id}/versioned_ehr_status/revision_history")
    public List<Versioned_Status> getVersionedStatusHistory(@PathVariable String ehr_id){

        EHR ehr = ehrrepo.findBy_id(ehr_id);
        System.out.println(ehr);

        Status st = new Status();
        List<Versioned_Status> vs = versStatusrepo.findByUidValue(ehr_id);

        return vs;
    }

    // Esta feito
    @GetMapping("/ehr/{ehr_id}/versioned_ehr_status/version{?version_at_time}")
    public Versioned_Status getVersionedStatusTime(@PathVariable String ehr_id, @RequestParam(required = false) String version_at_time){

        EHR ehr = ehrrepo.findBy_id(ehr_id);
        System.out.println(ehr);

        Versioned_Status vs = new Versioned_Status();
        if(version_at_time==null){
            vs = versStatusrepo.findBy_id(ehr.getId_status());
        }else {
            vs = versStatusrepo.findByUidValueAndTimecreatedValue(ehr_id, version_at_time);
        }

        return vs;
    }

    // Esta feito
    @GetMapping("/ehr/{ehr_id}/versioned_ehr_status/version/{version_uid}")
    public Versioned_Status getVersionedStatusByUId(@PathVariable String ehr_id, @PathVariable String version_uid){

        return versStatusrepo.findBy_idAndUidValue(version_uid, ehr_id);
    }


    @PutMapping("/ehr/{ehr_id}/ehr_status")
    public Status putStatus(@PathVariable String ehr_id, @RequestHeader("If-Match") String ifMatch, @RequestHeader("Prefer") String prefer, @RequestBody String body){

        EHR ehr1 = ehrrepo.findBy_id(ehr_id);
        Versioned_Status vs1 = versStatusrepo.findBy_id(ehr1.getId_status());
        if(ifMatch.equals(vs1.getStatusid().getId().getValue())) {

            Document doc = Document.parse(body);

            Document doc1 = mt.insert(doc, "status");
            String result = doc1.get("_id").toString();
            Versioned_Status vs = new Versioned_Status();
            TypeValueId tvi = new TypeValueId();
            TypeValue tv = new TypeValue();
            tv.set_type("HIER_OBJECT_ID");
            tv.setValue(result);
            tvi.setId(tv);
            tvi.setNamespace("local");
            tvi.setType("EHR");
            vs.setStatusid(tvi);
            vs.setCommiter("ze");
            vs.set_type("VERSIONED_EHR_STATUS");
            ObjectValue ov = new ObjectValue();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'HH:MM'Z'");
            Date d = new Date(System.currentTimeMillis());
            ov.setValue(sdf.format(d));
            vs.setTimecreated(ov);
            ObjectValue ov1 = new ObjectValue();
            ov1.setValue(ehr_id);
            vs.setUid(ov1);

            vs = versStatusrepo.insert(vs);

            EHR ehr = ehrrepo.findBy_id(ehr_id);
            ehr.setId_status(vs.get_id());
            mongoOperation.save(ehr);
            System.out.println(result);

            if(prefer.equals("representation")){
                return statusrepo.findBy_id(result);
            }
            else{
                Status status = new Status();
                status.set_type("Created");
                return status;
            }
        }

        return null;
    }





}

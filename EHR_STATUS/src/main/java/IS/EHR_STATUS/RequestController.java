package IS.EHR_STATUS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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

    @GetMapping("/ehr/{ehr_id}/ehr_status{?version_at_time}")
    public Status getStatus(@PathVariable String ehr_id, @RequestParam(required = false) String version_at_time){

        EHR ehr = ehrrepo.findBy_id(ehr_id);
        System.out.println(ehr);

        Status st = new Status();
        Versioned_Status vs = new Versioned_Status();
        if(version_at_time==null){
            st = statusrepo.findBy_id(ehr.getId_status());
        }else {
            vs = versStatusrepo.findByUidValueAndTimecreated(ehr_id, version_at_time);
            st = statusrepo.findBy_id(vs.getOwner());
        }


        return st;
    }

    @GetMapping("/ehr/{ehr_id}/ehr_status/{uid}")
    public Status getStatusByUId(@PathVariable String ehr_id, @PathVariable String uid){

        EHR ehr = ehrrepo.findBy_id(ehr_id);
        System.out.println(ehr);

        Status st = new Status();
        Versioned_Status vs = new Versioned_Status();

        vs = versStatusrepo.findBy_id(uid);
        st = statusrepo.findBy_id(vs.getOwner());


        return st;
    }

    @GetMapping("/ehr/{ehr_id}/versioned_ehr_status")
    public Versioned_Status getVersionedStatus(@PathVariable String ehr_id){

        EHR ehr = ehrrepo.findBy_id(ehr_id);
        System.out.println(ehr);

        Status st = new Status();
        Versioned_Status vs = new Versioned_Status();

        vs = versStatusrepo.findByUidValue(ehr_id);


        return vs;
    }

    @GetMapping("/ehr/{ehr_id}/versioned_ehr_status/revision_history")
    public Status getVersionedStatusHistory(@PathVariable String ehr_id){

        EHR ehr = ehrrepo.findBy_id(ehr_id);
        System.out.println(ehr);

        Status st = new Status();
        Versioned_Status vs = new Versioned_Status();

        st = statusrepo.findBy_id(ehr.getId_status());


        return st;
    }





}

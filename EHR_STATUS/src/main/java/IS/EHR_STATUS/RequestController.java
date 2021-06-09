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
    public Access getAccess(@RequestParam String id_worker, @RequestParam String id_ehr) {

        Access a = new Access();
        a.setId_worker(id_worker);
        a.setId_ehr(id_ehr);
        a.set_id("60c0dec1f3bdaa4e482a56d6");
        a.setAccess(3);
        Example<Access> e = Example.of(a);
        //accessrepo.arroz(id_worker);
/*
        if(!access.()){
            return accesses;
        }*/

        return null;
    }



}

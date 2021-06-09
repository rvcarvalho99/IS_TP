package IS.EHR_STATUS;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class RequestController {

    public EHRRepository ehrrepo;
    @GetMapping("/getInfo")
    public List<EHR> getInfo() {


        return ehrrepo.findAll();
    }



}

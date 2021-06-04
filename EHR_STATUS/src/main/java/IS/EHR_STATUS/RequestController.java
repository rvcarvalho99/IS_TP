package IS.EHR_STATUS;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {




    @GetMapping("/getInfo")
    public String getInfo(@RequestParam String Arroz) {

        DB_Access dba = new DB_Access();

        dba.get_EHR_Id_Status("1");
        return dba.get_EHR_Id_Status("1");
    }



}

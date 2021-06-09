package IS.EHR_STATUS;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "EHR")
public class EHR {

    @Id
    private long id;
    private String access;
    private String name;
    private String work;    

    public EHR(){
        super();
    }



}

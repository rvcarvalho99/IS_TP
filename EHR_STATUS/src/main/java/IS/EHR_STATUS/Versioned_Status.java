package IS.EHR_STATUS;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "versioned_status")
public class Versioned_Status {

    @Id
    private String _id;
    private Uid uid;
    private String ownerid;
    private String timecreated;

    public Versioned_Status(){
        super();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Uid getUid() {
        return uid;
    }

    public void setUid(Uid uid) {
        this.uid = uid;
    }

    public String getOwner() {
        return ownerid;
    }

    public void setOwner(String owner) {
        this.ownerid = owner;
    }

    public String getTimecreated() {
        return timecreated;
    }

    public void setTime_created(String timecreated) {
        this.timecreated = timecreated;
    }
}

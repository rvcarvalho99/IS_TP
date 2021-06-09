package IS.EHR_STATUS;

import org.springframework.data.annotation.Id;

public class Versioned_Status {

    @Id
    private String _id;
    private String owner_id;
    private String time_created;

    public Versioned_Status(){
        super();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getTime_created() {
        return time_created;
    }

    public void setTime_created(String time_created) {
        this.time_created = time_created;
    }
}

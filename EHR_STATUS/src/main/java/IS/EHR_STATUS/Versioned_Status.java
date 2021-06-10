package IS.EHR_STATUS;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "versioned_status")
public class Versioned_Status {

    @Id
    private String _id;
    private String _type;
    private ObjectValue uid;
    @Field("statusid")
    private TypeValueId statusid;
    @Field("timecreated")
    private ObjectValue timecreated;
    private String commiter;

    public Versioned_Status(){
        super();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public ObjectValue getUid() {
        return uid;
    }

    public void setUid(ObjectValue uid) {
        this.uid = uid;
    }

    public TypeValueId getStatusid() {
        return statusid;
    }

    public void setStatusid(TypeValueId statusid) {
        this.statusid = statusid;
    }

    public ObjectValue getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(ObjectValue timecreated) {
        this.timecreated = timecreated;
    }

    public String getCommiter() {
        return commiter;
    }

    public void setCommiter(String commiter) {
        this.commiter = commiter;
    }
}

package IS.EHR_STATUS;

import org.springframework.data.annotation.Id;

public class EHR {

    @Id
    private String _id;
    private String id_status;
    private String ehr_subject;


    public EHR(){
        super();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId_status() {
        return id_status;
    }

    public void setId_status(String id_status) {
        this.id_status = id_status;
    }

    public String getEhr_subject() {
        return ehr_subject;
    }

    public void setEhr_subject(String ehr_subject) {
        this.ehr_subject = ehr_subject;
    }
}

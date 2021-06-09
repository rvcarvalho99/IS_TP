package IS.EHR_STATUS;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "access")
public class Access {

        @Id
        private String _id;
        private String id_worker;
        private String id_ehr;
        private int access;

        public Access(){
            super();
        }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId_worker() {
        return id_worker;
    }

    public void setId_worker(String id_worker) {
        this.id_worker = id_worker;
    }

    public String getId_ehr() {
        return id_ehr;
    }

    public void setId_ehr(String id_ehr) {
        this.id_ehr = id_ehr;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }
}



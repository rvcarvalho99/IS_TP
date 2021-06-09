package IS.EHR_STATUS;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "access")
public class Access {

        @Id
        private String _id;
        private String worker;
        private String ehr;
        private String access;

        public Access(){
            super();
        }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getEhr() {
        return ehr;
    }

    public void setEhr(String ehr) {
        this.ehr = ehr;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}



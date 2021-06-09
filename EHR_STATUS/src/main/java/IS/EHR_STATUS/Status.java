package IS.EHR_STATUS;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "status")
public class Status {

    @Id
    private String _id;
    private String name;
    private String archetype_node_id;
    private String ehr_subject;
    private String is_modifiable;
    private String is_queryable;

    public Status(){
        super();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArchetype_node_id() {
        return archetype_node_id;
    }

    public void setArchetype_node_id(String archetype_node_id) {
        this.archetype_node_id = archetype_node_id;
    }

    public String getEhr_subject() {
        return ehr_subject;
    }

    public void setEhr_subject(String ehr_subject) {
        this.ehr_subject = ehr_subject;
    }

    public String getIs_modifiable() {
        return is_modifiable;
    }

    public void setIs_modifiable(String is_modifiable) {
        this.is_modifiable = is_modifiable;
    }

    public String getIs_queryable() {
        return is_queryable;
    }

    public void setIs_queryable(String is_queryable) {
        this.is_queryable = is_queryable;
    }


}

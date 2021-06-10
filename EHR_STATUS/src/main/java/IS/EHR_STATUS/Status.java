package IS.EHR_STATUS;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "status")
public class Status {

    @Id
    private String _id;
    private String _type;
    private String archetype_node_id;
    private ObjectValue name;
    private TypeValue uid;
    private ExternalRef subject;
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

    public ObjectValue getName() {
        return name;
    }

    public void setName(ObjectValue name) {
        this.name = name;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String getArchetype_node_id() {
        return archetype_node_id;
    }

    public void setArchetype_node_id(String archetype_node_id) {
        this.archetype_node_id = archetype_node_id;
    }

    public TypeValue getUid() {
        return uid;
    }

    public void setUid(TypeValue uid) {
        this.uid = uid;
    }

    public ExternalRef getSubject() {
        return subject;
    }

    public void setSubject(ExternalRef subject) {
        this.subject = subject;
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

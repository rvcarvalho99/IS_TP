package IS.EHR_STATUS;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class TypeValueId {

    @Field("id")
    private TypeValue id;
    private String namespace;
    private String type;

    public TypeValueId(){
        super();
    }

    public TypeValue getId() {
        return id;
    }

    public void setId(TypeValue id) {
        this.id = id;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

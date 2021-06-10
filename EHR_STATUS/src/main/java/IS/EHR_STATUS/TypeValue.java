package IS.EHR_STATUS;

public class TypeValue {

    private String _type;
    private String value;

    public TypeValue(){
        super();
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

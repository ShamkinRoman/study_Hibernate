package mappingXML.placeholder;

public class BodyCreate {
    private String id=null;
    private String nameBody;

    public BodyCreate(String id, String nameBody) {
        this.id = id;
        this.nameBody = nameBody;
    }

    public BodyCreate(String nameBody) {
        this.nameBody = nameBody;
    }

    public Integer getId() {
        return id!= null ? Integer.parseInt(id) : null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameBody() {
        return nameBody;
    }

    public void setNameBody(String nameBody) {
        this.nameBody = nameBody;
    }
}

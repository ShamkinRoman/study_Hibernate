package mappingXML;

public class Body {
    private Integer id;
    private String nameBody;

    public Body() {
    }

    public Body(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBody() {
        return nameBody;
    }

    public void setNameBody(String nameBody) {
        this.nameBody = nameBody;
    }

    @Override
    public String toString() {
        return "Body{" +
                "id=" + id +
                ", nameBody='" + nameBody + '\'' +
                '}';
    }
}

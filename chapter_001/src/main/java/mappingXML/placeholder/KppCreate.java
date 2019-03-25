package mappingXML.placeholder;

public class KppCreate {
    private String id = null;
    private String nameKpp;

    public KppCreate(String id, String nameKpp) {
        this.id = id;
        this.nameKpp = nameKpp;
    }

    public KppCreate(String nameKpp) {
        this.nameKpp = nameKpp;
    }

    public Integer getId() {
        return id != null ? Integer.parseInt(id) : null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameKpp() {
        return nameKpp;
    }

    public void setNameKpp(String nameKpp) {
        this.nameKpp = nameKpp;
    }
}

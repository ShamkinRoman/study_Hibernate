package mappingXML.placeholder;

public class EngineCreate {
    private String id = null;
    private String engineName;

    public EngineCreate(String id, String engineName) {
        this.id = id;
        this.engineName = engineName;
    }

    public EngineCreate(String engineName) {
        this.engineName = engineName;
    }

    public Integer getId() {
        return id != null ? Integer.parseInt(id) : null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }
}

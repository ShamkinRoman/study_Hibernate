package mapping;

public class Engine {
    private Integer id;
    private String engineName;

    public Engine() {
    }

    public Engine(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", engineName='" + engineName + '\'' +
                '}';
    }
}

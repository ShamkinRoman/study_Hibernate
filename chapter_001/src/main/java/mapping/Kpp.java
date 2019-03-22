package mapping;

public class Kpp {
    private Integer id;
    private String nameKpp;

    public Kpp() {
    }

    public Kpp(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameKpp() {
        return nameKpp;
    }

    public void setNameKpp(String modelKpp) {
        this.nameKpp = modelKpp;
    }

    @Override
    public String toString() {
        return "Kpp{" +
                "id=" + id +
                ", nameKpp='" + nameKpp + '\'' +
                '}';
    }
}

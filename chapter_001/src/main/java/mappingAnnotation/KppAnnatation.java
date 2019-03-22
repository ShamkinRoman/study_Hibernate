package mappingAnnotation;

import javax.persistence.*;

@Entity
@Table(name = "kpp")
public class KppAnnatation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nameKpp")
    private String nameKpp;

    public KppAnnatation() {
    }

    public KppAnnatation(Integer id) {
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

    public void setNameKpp(String nameKpp) {
        this.nameKpp = nameKpp;
    }
}

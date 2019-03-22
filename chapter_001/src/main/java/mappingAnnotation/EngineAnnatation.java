package mappingAnnotation;

import javax.persistence.*;

@Entity
@Table(name = "engine")
public class EngineAnnatation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nameEngine")
    private String nameEngine;

    public EngineAnnatation() {
    }

    public EngineAnnatation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameEngine() {
        return nameEngine;
    }

    public void setNameEngine(String nameEngine) {
        this.nameEngine = nameEngine;
    }
}

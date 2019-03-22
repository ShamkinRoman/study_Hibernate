package mappingAnnotation;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class CarAnnatation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nameCar")
    private String nameCar;
    @ManyToOne
    @JoinColumn(name = "body_id", foreignKey = @ForeignKey(name = "body_id"))
    private BodyAnnatation body_id;
    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "engine_id"))
    private EngineAnnatation engine_id;
    @ManyToOne
    @JoinColumn(name = "kpp_id", foreignKey = @ForeignKey(name = "kpp_id"))
    private KppAnnatation kpp_id;

    public CarAnnatation() {
    }

    public CarAnnatation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public BodyAnnatation getBody_id() {
        return body_id;
    }

    public void setBody_id(BodyAnnatation body_id) {
        this.body_id = body_id;
    }

    public EngineAnnatation getEngine_id() {
        return engine_id;
    }

    public void setEngine_id(EngineAnnatation engine_id) {
        this.engine_id = engine_id;
    }

    public KppAnnatation getKpp_id() {
        return kpp_id;
    }

    public void setKpp_id(KppAnnatation kpp_id) {
        this.kpp_id = kpp_id;
    }
}

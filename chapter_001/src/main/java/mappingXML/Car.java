package mappingXML;

public class Car {
    private Integer id;
    private String nameCar;
    private Body body_id;
    private Engine engine_id;
    private Kpp kpp_id;

    public Car() {
    }

    public Car(Integer id) {
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

    public Body getBody_id() {
        return body_id;
    }

    public void setBody_id(Body body_id) {
        this.body_id = body_id;
    }

    public Engine getEngine_id() {
        return engine_id;
    }

    public void setEngine_id(Engine engine_id) {
        this.engine_id = engine_id;
    }

    public Kpp getKpp_id() {
        return kpp_id;
    }

    public void setKpp_id(Kpp kpp_id) {
        this.kpp_id = kpp_id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", nameCar='" + nameCar + '\'' +
                ", body_id=" + body_id +
                ", engine_id=" + engine_id +
                ", kpp_id=" + kpp_id +
                '}';
    }
}

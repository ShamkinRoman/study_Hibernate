package mappingXML.placeholder;

import mappingXML.Body;
import mappingXML.Engine;
import mappingXML.Kpp;

public class CarCreate {
    private String id = null;
    private String nameCar;
    private String body_id;
    private String engine_id;
    private String kpp_id;

    public CarCreate(String nameCar, String body_id, String engine_id, String kpp_id) {
        this.nameCar = nameCar;
        this.body_id = body_id;
        this.engine_id = engine_id;
        this.kpp_id = kpp_id;
    }

    public CarCreate(String id, String nameCar, String body_id, String engine_id, String kpp_id) {
        this.id = id;
        this.nameCar = nameCar;
        this.body_id = body_id;
        this.engine_id = engine_id;
        this.kpp_id = kpp_id;
    }

    public Integer getId() {
        return id != null ? Integer.parseInt(id) : null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public Body getBody_id() {
        return (Body) new FindObject().findOne(String.format("from Body where nameBody = '%s'", body_id));
    }

    public void setBody_id(String body_id) {
        this.body_id = body_id;
    }

    public Engine getEngine_id() {
        return (Engine) new FindObject().findOne(String.format("from Engine where engineName = '%s'",engine_id));
    }

    public void setEngine_id(String engine_id) {
        this.engine_id = engine_id;
    }

    public Kpp getKpp_id() {
        return (Kpp) new FindObject().findOne(String.format("from Kpp where nameKpp = '%s'",kpp_id));
    }

    public void setKpp_id(String kpp_id) {
        this.kpp_id = kpp_id;
    }
}

package saleCars;

import mappingXML.Customer;

public class ItemCreate {
    private final ServiceItem service = ServiceItem.getINSTANCE();
    private String id = null;
    private String nameCar;
    private String body;
    private String engine;
    private String transmission;
    private String done;
    private String customer_id;

    public ItemCreate(String id, String nameCar, String body, String engine, String transmission, String done, String customer_id) {
        this.id = id;
        this.nameCar = nameCar;
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
        this.done = done;
        this.customer_id = customer_id;
    }

    public ItemCreate(String nameCar, String body, String engine, String transmission, String done, String customer_id) {
        this.nameCar = nameCar;
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
        this.done = done;
        this.customer_id = customer_id;
    }

    public Integer getId() {
        return id!=null ? Integer.parseInt(id) : null;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Boolean getDone() {
        Boolean result = false;
        if (this.done.equals("true")) {
            result = true;
        }
        return result;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public Customer getCustomer_id() {
        return service.findCustomer(Integer.parseInt(customer_id));
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "ItemCreate{" +
                "id='" + id + '\'' +
                ", nameCar='" + nameCar + '\'' +
                ", body='" + body + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", done='" + done + '\'' +
                ", customer_id='" + customer_id + '\'' +
                '}';
    }
}

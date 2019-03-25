package mappingXML.placeholder;

import mappingXML.Car;
import mappingXML.Customer;

public class FinishCarCreate {
    private String id = null;
    private String done;
    private String user_id;
    private String car_id;

    public FinishCarCreate(String done, String user_id, String car_id) {
        this.done = done;
        this.user_id = user_id;
        this.car_id = car_id;
    }

    public FinishCarCreate(String id, String done, String user_id, String car_id) {
        this.id = id;
        this.done = done;
        this.user_id = user_id;
        this.car_id = car_id;
    }

    public Integer getId() {
        return id != null ? Integer.parseInt(id) : null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDone() {
        Boolean result = false;
        if (done.equals("true"))
            result = true;
        return result;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public Customer getUser_id() {
        return (Customer) new FindObject().findOne("from Customer where id = " + user_id);
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Car getCar_id() {
        return (Car) new FindObject().findOne("from Car where id = " + car_id);
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }
}

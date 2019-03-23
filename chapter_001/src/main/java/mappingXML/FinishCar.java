package mappingXML;

public class FinishCar {
    private Integer id;
    private Customer user_id;
    private Car car_id;

    public FinishCar() {
    }

    public FinishCar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getUser_id() {
        return user_id;
    }

    public void setUser_id(Customer user_id) {
        this.user_id = user_id;
    }

    public Car getCar_id() {
        return car_id;
    }

    public void setCar_id(Car car_id) {
        this.car_id = car_id;
    }

    @Override
    public String toString() {
        return "FinishCar{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", car_id=" + car_id +
                '}';
    }
}

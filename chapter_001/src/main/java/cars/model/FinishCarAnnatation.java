package cars.model;

import javax.persistence.*;

@Entity
@Table(name = "finishcar")
public class FinishCarAnnatation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "done")
    private Boolean done;
    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id"))
    private CustomerAnnatation user_id;
    @ManyToOne
    @JoinColumn(name = "car_id", foreignKey = @ForeignKey(name = "car_id"))
    private CarAnnatation car_id;
    @Column(name = "linkToFile")
    private String linkToFile;

    public FinishCarAnnatation() {
    }

    public FinishCarAnnatation(Integer id) {
        this.id=id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public CustomerAnnatation getUser_id() {
        return user_id;
    }

    public void setUser_id(CustomerAnnatation user_id) {
        this.user_id = user_id;
    }

    public CarAnnatation getCar_id() {
        return car_id;
    }

    public void setCar_id(CarAnnatation car_id) {
        this.car_id = car_id;
    }

    public String getLinkToFile() {
        return linkToFile;
    }

    public void setLinkToFile(String linkToFile) {
        this.linkToFile = linkToFile;
    }

    @Override
    public String toString() {
        return "FinishCarAnnatation{" +
                "id=" + id +
                ", done=" + done +
                ", user_id=" + user_id +
                ", car_id=" + car_id +
                ", linkToFile='" + linkToFile + '\'' +
                '}';
    }
}

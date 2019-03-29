package cars.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerAnnatation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nameCustomer")
    private String nameCustomer;
    @Column(name = "passwordCustomer")
    private String passwordCustomer;

    public CustomerAnnatation() {
    }

    public CustomerAnnatation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPasswordCustomer() {
        return passwordCustomer;
    }

    public void setPasswordCustomer(String passwordCustomer) {
        this.passwordCustomer = passwordCustomer;
    }

    @Override
    public String toString() {
        return "CustomerAnnatation{" +
                "id=" + id +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", passwordCustomer='" + passwordCustomer + '\'' +
                '}';
    }
}

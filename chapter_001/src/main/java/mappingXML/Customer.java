package mappingXML;

public class Customer {
    private Integer id;
    private String nameCustomer;
    private String passwordCustomer;

    public Customer() {
    }

    public Customer(Integer id) {
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
        return "Customer{" +
                "id=" + id +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", passwordCustomer='" + passwordCustomer + '\'' +
                '}';
    }
}

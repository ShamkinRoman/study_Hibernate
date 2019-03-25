package mappingXML.placeholder;

public class CustomerCreate {
    private String id = null;
    private String nameCustomer;
    private String passwordCustomer;

    public CustomerCreate(String id, String nameCustomer, String passwordCustomer) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.passwordCustomer = passwordCustomer;
    }

    public CustomerCreate(String nameCustomer, String passwordCustomer) {
        this.nameCustomer = nameCustomer;
        this.passwordCustomer = passwordCustomer;
    }

    public Integer getId() {
        return id != null ? Integer.parseInt(id) : null;
    }

    public void setId(String id) {
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
}

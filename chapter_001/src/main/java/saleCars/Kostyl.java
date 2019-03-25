package saleCars;

import mappingXML.Body;
import mappingXML.Customer;
import mappingXML.Engine;
import mappingXML.Kpp;
import mappingXML.placeholder.FindObject;

public class Kostyl {
    private String bodyCar;
    private String engine;
    private String transmission;
    private String user;
    private String linkToFile;
    private String carName;

    public Kostyl(String bodyCar, String engine, String transmission, String user, String linkToFile, String carName) {
        this.bodyCar = bodyCar;
        this.engine = engine;
        this.transmission = transmission;
        this.user = user;
        this.linkToFile = linkToFile;
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getBodyCar() {
        return ((Body) new FindObject().findOne(String.format("from Body where nameBody = '%s'", bodyCar))).getId();
    }

    public void setBodyCar(String bodyCar) {
        this.bodyCar = bodyCar;
    }

    public Integer getEngine() {
        return ((Engine) new FindObject().findOne(String.format("from Engine where nameEngine = '%s'", engine))).getId();
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getTransmission() {
        return ((Kpp) new FindObject().findOne(String.format("from Kpp where nameKpp = '%s'", transmission))).getId();
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Integer getUser() {
        return ((Customer) new FindObject().findOne(String.format("from Customer where nameCustomer = '%s'", user))).getId();
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLinkToFile() {
        return linkToFile;
    }

    public void setLinkToFile(String linkToFile) {
        this.linkToFile = linkToFile;
    }

    @Override
    public String toString() {
        return "Kostyl{" +
                "bodyCar='" + bodyCar + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", user='" + user + '\'' +
                ", linkToFile='" + linkToFile + '\'' +
                ", carName='" + carName + '\'' +
                '}';
    }
}

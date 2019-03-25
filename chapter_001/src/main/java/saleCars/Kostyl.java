package saleCars;

public class Kostyl {
    private String bodyCar;
    private String engine;
    private String transmission;

    public Kostyl(String bodyCar, String engine, String transmission) {
        this.bodyCar = bodyCar;
        this.engine = engine;
        this.transmission = transmission;
    }

    public String getBodyCar() {
        return bodyCar;
    }

    public void setBodyCar(String bodyCar) {
        this.bodyCar = bodyCar;
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

    @Override
    public String toString() {
        return "Kostyl{" +
                "bodyCar='" + bodyCar + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                '}';
    }
}

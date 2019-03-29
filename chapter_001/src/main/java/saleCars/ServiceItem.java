package saleCars;

import com.google.gson.Gson;
import mappingXML.Car;
import mappingXML.Customer;
import mappingXML.FinishCar;
import mappingXML.Item;

import java.util.Collection;
import java.util.List;

public class ServiceItem implements AutoCloseable {
    private final StorageItem storage = StorageItem.getInstance();
    private static ServiceItem INSTANCE = new ServiceItem();

    private ServiceItem() {
    }

    public static ServiceItem getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void close() throws Exception {
        this.storage.close();
    }

    protected List<Item> getListTask(String string) {
        return storage.getListTask(string);
    }

    protected String getListTaskAsJson(String string) {
        String json = new Gson().toJson(getListTask(string));
        return json;
    }
//    protected void add(String string){
//        storage.addTask(makeItem(string));
//    }

    protected ItemCreate makeItem(String string) {
        Gson gson = new Gson();
        ItemCreate itemCreateToAdd = gson.fromJson(string, ItemCreate.class); //Подставной класс для удобства.
        System.out.println("incoming task " + itemCreateToAdd.toString()); // для проверки.
        return itemCreateToAdd;
    }

    protected Customer findCustomer(Integer id) {
        return storage.findCustomerById(id);
    }

    protected Car addCar(Kostyl kostyl) {
        return storage.addCar(kostyl);
    }

    protected void addFinishCar(Kostyl kostyl) {
        storage.addFinishCar(kostyl);
    }

    protected List<FinishCar> getFinishCars(){
        return storage.getFinishCars("From FinishCar");
    }

}

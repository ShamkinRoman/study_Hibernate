package saleCars;

import createTODOlist.Task;
import mappingXML.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class StorageItem implements AutoCloseable {
    private final SessionFactory factory = SessionFactorySingleton.getSessionFactory();
    private static StorageItem instance = new StorageItem();
    private List<Item> items;

    private StorageItem() {
    }

    public static StorageItem getInstance() {
        return instance;
    }

    @Override
    public void close() throws Exception {
        this.factory.close();
    }

    protected List<Item> getListTask(String string) {
        Session session = factory.openSession();
        session.beginTransaction();
//        if (!string.equals("all"))
//            items = session.createQuery("from Task where done=true").list();
//        else
        items = session.createQuery("from Item").list();
        session.getTransaction().commit();
        session.close();
        return items;
    }

    /**
     * Добавляем или обновляем запись в БД.
     *
     * @param kostyl Запись для внисения в БД.
     */
    protected Car addCar(Kostyl kostyl) {
        Session session = factory.openSession();
        Car car = new Car();
        session.beginTransaction();
        car.setNameCar(kostyl.getCarName());
        car.setBody_id(new Body(kostyl.getBodyCar()));
        car.setEngine_id(new Engine(kostyl.getEngine()));
        car.setKpp_id(new Kpp(kostyl.getTransmission()));
        session.saveOrUpdate(car);
        session.getTransaction().commit();
        session.close();
        return car;
    }

    protected void addFinishCar(Kostyl kostyl) {
        Car car = addCar(kostyl);
        Session session = factory.openSession();
        FinishCar finishCar = new FinishCar();
        session.beginTransaction();
        finishCar.setDone(false); //доработать
        finishCar.setLinkToFile(kostyl.getLinkToFile());
        finishCar.setCar_id(car);
        finishCar.setUser_id(new Customer(kostyl.getUser()));
        session.saveOrUpdate(finishCar);
        session.getTransaction().commit();
        session.close();
    }

    protected Customer findCustomerById(Integer id) {
        Session session = factory.openSession();
        Customer customer;
        session.beginTransaction();
        customer = (Customer) session.createQuery("from Customer where id=" + id.toString()).list().get(0);
        session.getTransaction().commit();
        session.close();
        return customer;
    }

    protected List<FinishCar> getFinishCars(String string) {
        List<FinishCar> carsList;
        Session session = factory.openSession();
        session.beginTransaction();
        carsList = (List<FinishCar>) session.createQuery("from FinishCar ").list();
        session.getTransaction().commit();
        session.close();
        return  carsList;
    }


}

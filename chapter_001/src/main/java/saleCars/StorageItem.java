package saleCars;

import createTODOlist.Task;
import mappingXML.Customer;
import mappingXML.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
     * @param itemCreate Запись для внисения в БД.
     */
    protected void addTask(ItemCreate itemCreate) {
        Session session = factory.openSession();
        Item item = new Item();
        session.beginTransaction();
        item.setBody(itemCreate.getBody());
        item.setDone(itemCreate.getDone());
        item.setEngine(itemCreate.getEngine());
        item.setTransmission(itemCreate.getTransmission());
        item.setNameCar(itemCreate.getNameCar());
        item.setCustomer_id(itemCreate.getCustomer_id());
        session.saveOrUpdate(item);
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



}

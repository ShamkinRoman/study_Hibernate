package saleCars;

import createTODOlist.Task;
import mappingXML.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

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
     * @param tempItem Запись для внисения в БД.
     */
    protected void addTask(Item tempItem) {
        Session session = factory.openSession();

        session.beginTransaction();
        session.saveOrUpdate(tempItem);
        session.getTransaction().commit();
        session.close();
    }
}

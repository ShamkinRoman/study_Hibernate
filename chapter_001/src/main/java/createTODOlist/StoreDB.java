package createTODOlist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для выполнения запросов записи и получения списка объектов в БД.
 */
public class StoreDB implements AutoCloseable {
    private final SessionFactory factory = SessionFactorySingleton.getSessionFactory();
    private static StoreDB instance = new StoreDB();

    private StoreDB() {
    }

    public static StoreDB getInstance() {
        return instance;
    }

    private List<Task> tasks;
    private List<Task> temp;


    @Override
    public void close() throws Exception {
        this.factory.close();
    }

    protected List<Task> getListTask(String string) {
        Session session = factory.openSession();
        session.beginTransaction();
        temp = session.createQuery("from Task").list();
        if (!string.equals("all")) {
            tasks = temp.stream().filter(x -> x.getDone()).collect(Collectors.toList());
        } else
            tasks = temp;
        session.getTransaction().commit();
        session.close();
        return tasks;
    }

    /**
     * Добавляем или обновляем запись в БД.
     *
     * @param querryDB Запись для внисения в БД.
     */
    protected void addTask(QuerryDB querryDB) {
        Task task = new Task();
        Session session = factory.openSession();
        if (querryDB.getId() != null) {
            task.setId(querryDB.getId());
        }
        session.beginTransaction();
        task.setCreated(new Timestamp(System.currentTimeMillis()));
        task.setDesc(querryDB.getDesc());
        task.setDone(querryDB.getDone());
        session.saveOrUpdate(task);
        session.getTransaction().commit();
        session.close();

    }
}

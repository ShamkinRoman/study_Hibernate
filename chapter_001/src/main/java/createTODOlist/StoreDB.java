package createTODOlist;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class StoreDB implements AutoCloseable {
    //        private static StoreDB instance = new StoreDB();
    private SessionFactory factory;
    private List<Task> tasks;
    private List<Task> temp;

    public StoreDB() {
        init();
    }

    protected void init() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

//    public StoreDB getInstance() {
//        return instance;
//    }

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
     * Добавляем запись в БД. Если есть id то вызваем обновление записи.
     *
     * @param querryDB Запись для внисения в БД.
     */
    protected void addTask(QuerryDB querryDB) {
        Task task = new Task();
        if (querryDB.getId() != null) {
            updateTask(querryDB);
        } else {
            Session session = factory.openSession();
            session.beginTransaction();
            task.setCreated(new Timestamp(System.currentTimeMillis()));
            task.setDesc(querryDB.getDesc());
            task.setDone(querryDB.getDone());
            session.saveOrUpdate(task);
            session.getTransaction().commit();
            session.close();
        }
    }

    protected void updateTask(QuerryDB querryDB) {
        Session session = factory.openSession();
        session.beginTransaction();
        Task task = new Task();
        task.setId(querryDB.getId());
        task.setDone(querryDB.getDone());
        task.setDesc(querryDB.getDesc());
        task.setCreated(new Timestamp(System.currentTimeMillis()));
        session.update(task);
        session.getTransaction().commit();
        session.close();
    }
}

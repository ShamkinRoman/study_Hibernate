package createTODOlist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class StoreDB implements AutoCloseable {
    private static StoreDB instance = new StoreDB();
    private Session session;
    private SessionFactory factory;
    private List<Task> tasks;
    private List<Task> temp;

    public StoreDB() {
        init();
    }

    protected void init(){
        this.factory = new Configuration().configure().buildSessionFactory();
        this.session = factory.openSession();
    }

    public StoreDB getInstance() {
        return instance;
    }

    @Override
    public void close() throws Exception {
        this.session.close();
        this.factory.close();
    }

    protected List<Task> getListTask(String string){
        session.beginTransaction();
        temp = session.createQuery("from Task").list();
        if (!string.equals("all")) {
            tasks = temp.stream().filter(x -> x.getDone()).collect(Collectors.toList());
        } else
            tasks = temp;
        session.getTransaction().commit();
        return tasks;
    }

    protected void addTask(QuerryDB querryDB) {
        session.beginTransaction();
        Task task = new Task();
        task.setCreated(new Timestamp(System.currentTimeMillis()));
        task.setDesc(querryDB.getDesc());
        task.setDone(querryDB.getDone());
        session.saveOrUpdate(task);
        session.getTransaction().commit();
    }

}

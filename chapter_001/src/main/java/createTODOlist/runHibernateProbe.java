package createTODOlist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;


public class runHibernateProbe {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Task task = new Task();
        task.setCreated(new Timestamp(System.currentTimeMillis()));
        task.setDesc("Изменили описание");
        task.setDone(true);
        task.setId(1);
        session.saveOrUpdate(task);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}

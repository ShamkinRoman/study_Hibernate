package saleCars;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tetst {
    public static void main(String[] args) {
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
//        session.beginTransaction();
//        session.createQuery("from FinishCar ").list().forEach(System.out::println);
//        session.createQuery("from Item ").list().forEach(System.out::println);
//        session.close();
//        factory.close();
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMddhhmmss");
        System.out.println(formatForDateNow.format(date));
        String path = "E:\\java\\study_Hibernate\\chapter_001\\target\\chapter_001-2.0\\upload\\001.JPG";
        System.out.println(path);

    }
}

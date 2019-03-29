package saleCars;

import com.google.gson.Gson;
import mappingXML.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class Tetst {
    public static void main(String[] args) {

        SessionFactory factory = SessionFactorySingleton.getSessionFactory();
        List<Car> cars;
        Session session = factory.openSession();
        session.beginTransaction();
        cars = session.createQuery("from Car ").list();
//        cars.forEach(System.out::println);
//        System.out.println(new Gson().toJson(cars));
        session.getTransaction().commit();
        session.close();
        cars.forEach(System.out::println);
//        System.out.println(new Gson().toJson(cars));
        factory.close();

    }
}

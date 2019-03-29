package cars.logic;

import cars.model.CarAnnatation;
import cars.model.CustomerAnnatation;
import cars.model.FinishCarAnnatation;
import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class test {
    public static void main(String[] args) {
        SessionFactory factory = SessionFactorySingleton.getSessionFactory();
        Session session = factory.openSession();
        List<FinishCarAnnatation> car;
        session.beginTransaction();
        car = session.createQuery("from FinishCarAnnatation").list();
//        car.forEach(System.out::println);
        session.getTransaction().commit();
        session.close();

//        car.forEach(System.out::println);
        System.out.println(new Gson().toJson(car));



        factory.close();

    }
}

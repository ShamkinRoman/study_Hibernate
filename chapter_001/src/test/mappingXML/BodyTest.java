package mappingXML;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

public class BodyTest {

    @Test
    public void createCar() throws SQLException {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Car car = new Car();
        session.beginTransaction();
        assertThat(session.createQuery("from Car where nameCar='TestCar'").list().size(), is(0));
        car.setKpp_id(new Kpp(1));
        car.setEngine_id(new Engine(1));
        car.setBody_id(new Body(1));
        car.setNameCar("TestCar");
        session.saveOrUpdate(car);
        assertThat(session.createQuery("from Car where nameCar='TestCar'").list().size(), is(1));
        session.getTransaction().rollback();
        session.close();
        factory.close();
    }

    @Test
    public void updateCar() throws SQLException {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Car car = new Car();
        session.beginTransaction();
        assertThat(session.createQuery("from Car where nameCar='TestCar'").list().size(), is(0));
        car.setKpp_id(new Kpp(1));
        car.setEngine_id(new Engine(1));
        car.setBody_id(new Body(1));
        car.setNameCar("TestCar");
        session.saveOrUpdate(car);
        assertThat(session.createQuery("from Car where nameCar='TestCar'").list().size(), is(1));
        Integer cars = session.createQuery("from Car").list().size(); //Узнаем сколько записей в БД.
        car.setNameCar("NewTestNameCar");
        session.update(car);
        assertThat(session.createQuery("from Car where nameCar='NewTestNameCar'").list().size(), is(1));
        assertThat(session.createQuery("from Car").list().size(), is(cars)); //проверяем что количество записей не изменилось.
        session.getTransaction().rollback();
        session.close();
        factory.close();
    }

    @Test
    public void deleteCar() throws SQLException {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Car car = new Car();
        session.beginTransaction();
        assertThat(session.createQuery("from Car where nameCar='TestCar'").list().size(), is(0));
        car.setKpp_id(new Kpp(1));
        car.setEngine_id(new Engine(1));
        car.setBody_id(new Body(1));
        car.setNameCar("TestCar");
        session.saveOrUpdate(car);
        assertThat(session.createQuery("from Car where nameCar='TestCar'").list().size(), is(1));
        session.delete(car);
        assertThat(session.createQuery("from Car where nameCar='TestCar'").list().size(), is(0));
        session.getTransaction().rollback();
        session.close();
        factory.close();
    }

}
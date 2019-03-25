package mappingXML.placeholder;

import mappingXML.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import saleCars.SessionFactorySingleton;


import java.util.List;
import java.util.function.Function;

public class FindObject {

    private SessionFactory factory = SessionFactorySingleton.getSessionFactory();

    private <T> T tx(final Function<Session, T> command) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }

    public Object findOneObj(final String question) {
        return this.tx(
                session -> {
                    try {
                        final Object object = session.createQuery(question).list().get(0);
                        return object;
                    } catch (Exception e) {
                        return null;
                    }
                }
        );
    }

    public Object findOne(String string) {
        Session session = factory.openSession();
        session.beginTransaction();
        List<Object> objectList = session.createQuery(string).list();
        System.out.println(objectList.size());
        objectList.forEach(System.out::println); //без этой строчки не работает.
        Object object = objectList.get(0);
        session.getTransaction().commit();
        session.close();
        return object;
    }

    public Boolean addCustomer(Customer customer) {
        Boolean result = false;
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.saveOrUpdate(customer);
            result = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }
}


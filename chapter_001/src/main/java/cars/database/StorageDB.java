package cars.database;


import cars.model.FinishCarAnnatation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.function.Function;

public class StorageDB implements AutoCloseable {
    private SessionFactory factory = SessionFactorySingleton.getSessionFactory();
    private static   StorageDB INSTANCE = new StorageDB();

    private StorageDB(){

    }

    public static StorageDB getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void close() throws Exception {
        factory.close();
    }

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

    public Collection<FinishCarAnnatation> getFinishCar() {
        return this.tx(
                session -> session.createQuery("from FinishCarAnnatation").list()
        );
    }
}

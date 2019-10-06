import model.ExampleEntity;
import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StartClass {
    public static void main(String[] args)
    {
        System.out.println("Hello world");

        final ExampleEntity ex1 = new ExampleEntity("funny data");
        final ExampleEntity ex2 = new ExampleEntity("another data");
        final ExampleEntity ex3 = new ExampleEntity("another data3");


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(ex1);
            session.save(ex2);
            session.save(ex3);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        System.out.println("put data into the DB. Trying to read");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final List<ExampleEntity> students = session.createQuery("from ExampleEntity", ExampleEntity.class).list();
            students.forEach(x -> System.out.println(x.getData()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

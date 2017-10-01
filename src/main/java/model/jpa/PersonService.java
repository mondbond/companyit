package model.jpa;

import com.sun.org.apache.xpath.internal.operations.String;
import entity.Person;
import model.DAO;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 30.09.2017.
 */
public class PersonService implements DAO<Person> {

    private Session currentSession;
    private Transaction currentTransaction;

    public PersonService() {
    }

    private void openSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
    }

    private void closeSession() {
        currentTransaction.commit();
        currentSession.close();
    }

    public void add(Person model) throws SQLException {
        openSession();
        currentSession.save(model);
        closeSession();
    }

    public Person getById(int id) {
        openSession();
        Person person = currentSession.load(Person.class, id);
        closeSession();
        return person;
    }

    public void deleteById(int id) {

    }

    public void save(Person model) {

    }

    public void edit(Person model) {

    }

    public void delete(Person model) {

    }

    public List<Person> getAll() {
        return null;
    }
}

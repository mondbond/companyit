package model.jpa;

import entity.Skill;
import model.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 01.10.2017.
 */
public class SkillService implements DAO<Skill> {

    private Session currentSession;
    private Transaction currentTransaction;

    public SkillService() {
    }

    private void openSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
    }

    private void closeSession() {
        currentTransaction.commit();
        currentSession.close();
    }

    public void add(Skill model) throws SQLException {
        openSession();
        currentSession.save(model);
        closeSession();
    }

    public Skill getById(int id) {
        return null;
    }

    public void deleteById(int id) {

    }

    public void save(Skill model) {

    }

    public void edit(Skill model) {

    }

    public void delete(Skill model) {

    }

    public List<Skill> getAll() {
        return null;
    }
}

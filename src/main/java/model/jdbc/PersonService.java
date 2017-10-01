package model.jdbc;

import entity.Person;
import model.DAO;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 30.09.2017.
 */
public class PersonService implements DAO<Person> {

    Connection connection;

    public void add(Person model) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO PERSON (NAME, POSITION, SALARY, INFO) VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getPosition());
            preparedStatement.setInt(3, model.getSalary());
            preparedStatement.setString(4, model.getInfo());

            preparedStatement.executeUpdate();

            closeConnection(preparedStatement);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Person getById(int id) {

        return null;
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
        try {
            connection = ConnectionUtil.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Person> people = new ArrayList<Person>();

        String sql = "SELECT * FROM PERSON";
        Statement statement;

        try {
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery(sql);

            while (r.next()){
                Person person = new Person(
                        r.getInt("id"),
                        r.getString("name"),
                        r.getString("position"),
                        r.getInt("salary"),
                        r.getString("info")
                );

                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection(null);
        return people;
    }

    private void closeConnection(PreparedStatement preparedStatement){
        try {
            if(preparedStatement != null){
                preparedStatement.close();
            }

            if(connection != null){
                    connection.close();
            }
        }
        catch (SQLException e) {
                e.printStackTrace();
        }
    }
}

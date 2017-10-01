import entity.Person;
import entity.Skill;
import model.jpa.PersonService;
import model.jpa.SkillService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by User on 30.09.2017.
 */
public class App {

    static Connection connection;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//
//        PersonService personService = new PersonService();
//        SkillService skillService = new SkillService();
//
//        Skill skill = new Skill("PYTHON", "", 90);
//        skillService.add(skill);
//
//        ArrayList<Skill> arrayList = new ArrayList<Skill>();
//        arrayList.add(skill);
//
//        Person person = new Person("Sasa Ser", "Python dev", 700, "good boy");
//        person.setSkills(arrayList);
//        personService.add(person);
    }

//    private static void addNewPerson (){
//        Person person = new Person("Dima Lor", "js dev", 1000, "drink a lot");
//        PersonService personService = new PersonService();
//        try {
//            personService.add(person);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void getAll(){
//        PersonService personService = new PersonService();
//        for(Person person : personService.getAll()) {
//            System.out.println(person.toString());
//        }
//    }
}

package entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by User on 30.09.2017.
 */

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private int salary;

    @Column(name = "info")
    private String info;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "person_skill", catalog = "company_it",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id")})
    private List<Skill> skills = new ArrayList<Skill>(0);


    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills){
        this.skills = skills;
    }

    public Person() {}

    public Person(int id, String name, String position, int salary, String info) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.info = info;
    }

    public Person(String name, String position, int salary, String info) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", info='" + info + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getId() != person.getId()) return false;
        if (getSalary() != person.getSalary()) return false;
        if (getName() != null ? !getName().equals(person.getName()) : person.getName() != null) return false;
        if (getPosition() != null ? !getPosition().equals(person.getPosition()) : person.getPosition() != null)
            return false;
        return getInfo() != null ? getInfo().equals(person.getInfo()) : person.getInfo() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        result = 31 * result + getSalary();
        result = 31 * result + (getInfo() != null ? getInfo().hashCode() : 0);
        return result;
    }
}

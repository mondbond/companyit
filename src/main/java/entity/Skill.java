package entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by User on 30.09.2017.
 */

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "info")
    private String info;

    @Column(name = "priority")
    private int priority;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "person_skill", catalog = "company_it",
            joinColumns = {@JoinColumn(name = "skill_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")})
    private List<Person> people = new ArrayList<Person>(0);

    public Skill() {}

    public Skill(String name, String info, int priority) {
        this.name = name;
        this.info = info;
        this.priority = priority;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<Person> getPersons(){
        return people;
    }

    public void setPersons(List<Person> persons){
        this.people = persons;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;

        Skill skill = (Skill) o;

        if (getId() != skill.getId()) return false;
        if (getPriority() != skill.getPriority()) return false;
        if (getName() != null ? !getName().equals(skill.getName()) : skill.getName() != null) return false;
        return getInfo() != null ? getInfo().equals(skill.getInfo()) : skill.getInfo() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getInfo() != null ? getInfo().hashCode() : 0);
        result = 31 * result + getPriority();
        return result;
    }
}

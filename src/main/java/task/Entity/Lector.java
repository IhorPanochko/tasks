package task.Entity;

import org.hibernate.annotations.Fetch;
import task.Enums.Degree;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lector implements Serializable {

    public Lector() {
    }

    public Lector(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Lector(String name, String surname, Double salary, Degree degree) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.degree = degree;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    private Double salary;

    @Column(name = "degree")
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToMany(mappedBy = "lectors",fetch = FetchType.LAZY)
    private List<Department>departments;


    public List<String> getStrings(){
        List<String>strings=new ArrayList<>();

        strings.add(name);
        strings.add(surname);
        strings.add(salary.toString());
        strings.add(degree.toString());
        return strings;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", degree=" + degree +
                '}';
    }
}

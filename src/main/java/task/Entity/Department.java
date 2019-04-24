package task.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    public Department(String departmentName) {
        this.departmentName = departmentName;

    }

    public Department(String departmentName, Lector head) {
        this.departmentName = departmentName;
        this.head = head;
    }

    public Department() {
    }

    @Id
    @GeneratedValue
    private Long id;

    private String departmentName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "department_lector",
    joinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"),
    inverseJoinColumns =  @JoinColumn(name = "lector_id", referencedColumnName = "id"))
    List<Lector>lectors;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Lector head;


    public List<String>getStrings(){
        List<String>strings=new ArrayList<>();
        strings.add(departmentName);
        strings.addAll(head.getStrings());
        return strings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }

    public Lector getHead() {
        return head;
    }

    public void setHead(Lector head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", lectors=" +lectors +
                ", head=" + head +
                '}';
    }
}

package model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Rank rankEmployee;

    @ManyToMany
    @JoinTable(name = "Employee_Project",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id") })
    private Set<Project> projects = new HashSet<>();

    public Employee() {
    }

    public Employee(String name, Rank rankEmployee) {
        this.name = name;
        this.rankEmployee = rankEmployee;
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

    public Rank getRankEmployee() {
        return rankEmployee;
    }

    public void setRankEmployee(Rank rankEmployee) {
        this.rankEmployee = rankEmployee;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

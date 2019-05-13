package model;

import javax.persistence.*;

@Entity
@Table
@NamedQuery(name = "get names by id", query = "SELECT c FROM Coders c WHERE c.id=:codersId")
public class Coders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Coders() {
    }

    public Coders(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Coders{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

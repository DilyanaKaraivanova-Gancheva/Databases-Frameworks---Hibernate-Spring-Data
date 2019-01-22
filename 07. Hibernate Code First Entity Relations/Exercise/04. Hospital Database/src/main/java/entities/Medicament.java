package entities;

import javax.persistence.*;

@Entity
@Table(name = "medicaments")
public class Medicament {
    private Long id;
    private String name;

    public Medicament() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

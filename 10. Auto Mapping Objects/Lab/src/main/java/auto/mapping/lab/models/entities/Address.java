package auto.mapping.lab.models.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "addresses")
public class Address {
    private Long id;
    private String city;
    private Set<Employee> residents;

    public Address() {
        this.residents = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @OneToMany(mappedBy = "address",fetch = FetchType.EAGER)
    public Set<Employee> getResidents() {
        return residents;
    }

    public void setResidents(Set<Employee> residents) {
        this.residents = residents;
    }
}

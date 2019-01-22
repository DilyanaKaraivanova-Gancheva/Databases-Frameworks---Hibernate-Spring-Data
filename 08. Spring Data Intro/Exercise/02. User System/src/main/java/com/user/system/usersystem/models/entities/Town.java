package com.user.system.usersystem.models.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {
    private Integer id;
    private String name;

    private Set<User> born;
    private Set<User> residents;
    private Country country;

    public Town() {
        this.born = new HashSet<>();
        this.residents = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "currentlyLiving")
    public Set<User> getResidents() {
        return residents;
    }

    public void setResidents(Set<User> residents) {
        this.residents = residents;
    }

    @OneToMany(mappedBy = "bornTown")
    public Set<User> getBorn() {
        return born;
    }

    public void setBorn(Set<User> born) {
        this.born = born;
    }

}

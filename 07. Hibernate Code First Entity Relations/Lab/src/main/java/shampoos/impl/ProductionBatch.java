package shampoos.impl;

import shampoos.interfaces.Batch;
import shampoos.interfaces.Shampoo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "batches")
public class ProductionBatch implements Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany(mappedBy = "batch",targetEntity = BasicShampoo.class,
    fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Shampoo> shampoos;

    public ProductionBatch() {
        this.shampoos = new HashSet<>();
    }

    public ProductionBatch(Set<Shampoo> shampoos) {
        this.shampoos = shampoos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Shampoo> getShampoos() {
        return shampoos;
    }

    public void setShampoos(Set<Shampoo> shampoos) {
        this.shampoos = shampoos;
    }
}

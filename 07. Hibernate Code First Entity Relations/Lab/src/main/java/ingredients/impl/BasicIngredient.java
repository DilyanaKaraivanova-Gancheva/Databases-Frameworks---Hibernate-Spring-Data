package ingredients.impl;

import ingredients.interfaces.Ingredient;
import shampoos.impl.BasicShampoo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ingredients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ingredient_type",discriminatorType = DiscriminatorType.STRING)
public abstract class BasicIngredient implements Ingredient {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String name;

    @Basic
    private BigDecimal price;

    @ManyToMany(mappedBy = "ingredients",targetEntity = BasicShampoo.class)
    private List<BasicShampoo> shampoos;

    protected BasicIngredient(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    protected BasicIngredient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<BasicShampoo> getShampoos() {
        return shampoos;
    }

    public void setShampoos(List<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}

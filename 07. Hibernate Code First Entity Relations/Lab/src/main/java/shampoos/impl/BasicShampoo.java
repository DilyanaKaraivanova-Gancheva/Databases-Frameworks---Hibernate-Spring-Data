package shampoos.impl;

import ingredients.impl.BasicIngredient;
import shampoos.enums.Size;
import shampoos.interfaces.Shampoo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shampoos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "shampoo_type",discriminatorType = DiscriminatorType.STRING)
public abstract class BasicShampoo implements Shampoo {

    @Id
    private long id;

    @Basic
    private BigDecimal price;

    @Basic
    private String brand;

    @OneToOne(optional = true,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "label", referencedColumnName = "id")
    private BasicLabel label;

    @ManyToOne(optional = false)
    @JoinColumn(name = "batch_id",referencedColumnName = "id")
    private ProductionBatch batch;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "shampoos_ingredients",joinColumns = @JoinColumn(name = "shampoo_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id",referencedColumnName = "id"))
    private Set<BasicIngredient> ingredients;

    @Enumerated
    private Size size;

    protected BasicShampoo() {

    }

    protected BasicShampoo(BigDecimal price, String brand, BasicLabel label, ProductionBatch batch, Size size) {
        this.price = price;
        this.brand = brand;
        this.label = label;
        this.batch = batch;
        this.ingredients = new HashSet<>();
        this.size = size;
    }

    public BasicShampoo(BigDecimal price, String brand, Size size) {
        this.price = price;
        this.brand = brand;
        this.size = size;
    }

    public BasicShampoo(BasicLabel label) {
        this.label = label;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public BasicLabel getLabel() {
        return this.label;
    }

    @Override
    public void setLabel(BasicLabel label) {
        this.label = label;
    }

    @Override
    public Set<BasicIngredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public void setIngredients(Set<BasicIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ProductionBatch getBatch() {
        return batch;
    }

    public void setBatch(ProductionBatch batch) {
        this.batch = batch;
    }
}

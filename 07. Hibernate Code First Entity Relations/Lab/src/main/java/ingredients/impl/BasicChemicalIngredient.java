package ingredients.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public abstract class BasicChemicalIngredient extends BasicIngredient{

    @Column(name = "chemical_formula")
    private String chemicalFormula;

    public BasicChemicalIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.setChemicalFormula(chemicalFormula);
    }

    public BasicChemicalIngredient() {
    }

    public String getChemicalFormula() {
        return chemicalFormula;
    }

    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }
}

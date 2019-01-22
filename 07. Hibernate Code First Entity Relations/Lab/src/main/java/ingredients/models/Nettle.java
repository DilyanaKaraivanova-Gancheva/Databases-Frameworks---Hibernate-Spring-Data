package ingredients.models;

import ingredients.impl.BasicIngredient;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "NT")
public class Nettle extends BasicIngredient {
    private static final String NAME = "Nettle";
    private static final BigDecimal PRICE = BigDecimal.valueOf(6.12);

    public Nettle() {
        super(NAME,PRICE);
    }
}

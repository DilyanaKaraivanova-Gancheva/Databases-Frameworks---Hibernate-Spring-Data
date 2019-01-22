package shampoos.models;

import ingredients.impl.BasicIngredient;
import ingredients.models.Nettle;
import ingredients.models.Strawberry;
import shampoos.impl.BasicLabel;
import shampoos.impl.BasicShampoo;
import shampoos.impl.ProductionBatch;
import shampoos.enums.Size;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "FS")
public class FiftyShades extends BasicShampoo {
    private static final String BRAND = "Fifty Shades";
    private static final BigDecimal PRICE = BigDecimal.valueOf(6.69);
    private static final Size SIZE = Size.SMALL;

    public FiftyShades() {
    }

    public FiftyShades(BasicLabel label, ProductionBatch batch) {
        super(PRICE,BRAND,label,batch,SIZE);
        Set<BasicIngredient> ingredients = new HashSet<>();
        ingredients.add(new Strawberry());
        ingredients.add(new Nettle());
        setIngredients(ingredients);

    }
}

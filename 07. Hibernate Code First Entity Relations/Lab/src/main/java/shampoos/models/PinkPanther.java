package shampoos.models;

import ingredients.impl.BasicIngredient;
import ingredients.models.Lavender;
import ingredients.models.Nettle;
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
@DiscriminatorValue(value = "PP")
public class PinkPanther extends BasicShampoo {
    private static final String BRAND = "Pink Panther";
    private static final BigDecimal PRICE = BigDecimal.valueOf(8.50);
    private static final Size SIZE = Size.MEDDIUM;

    public PinkPanther() {
    }

    public PinkPanther(BasicLabel label, ProductionBatch batch) {
        super(PRICE,BRAND,label,batch,SIZE);
        Set<BasicIngredient> ingredients = new HashSet<>();
        ingredients.add(new Lavender());
        ingredients.add(new Nettle());
        setIngredients(ingredients);

    }
}

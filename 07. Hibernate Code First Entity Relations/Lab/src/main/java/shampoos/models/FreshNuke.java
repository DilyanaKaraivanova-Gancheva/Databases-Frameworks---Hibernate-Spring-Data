package shampoos.models;

import ingredients.impl.BasicIngredient;
import ingredients.models.AmmoniumChloride;
import ingredients.models.Mint;
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
@DiscriminatorValue(value = "FN")
public class FreshNuke extends BasicShampoo {
    private static final String BRAND = "Fresh Nuke";
    private static final BigDecimal PRICE = BigDecimal.valueOf(9.33);
    private static final Size SIZE = Size.LARGE;

    public FreshNuke() {
    }

    public FreshNuke(BasicLabel label, ProductionBatch batch) {
        super(PRICE,BRAND,label,batch,SIZE);
        Set<BasicIngredient> ingredients = new HashSet<>();
        ingredients.add(new Mint());
        ingredients.add(new Nettle());
        ingredients.add(new AmmoniumChloride());
        setIngredients(ingredients);

    }

    public FreshNuke(BasicLabel label) {
        super(PRICE,BRAND,label,new ProductionBatch(),SIZE);
        Set<BasicIngredient> ingredients = new HashSet<>();
        ingredients.add(new Mint());
        ingredients.add(new Nettle());
        ingredients.add(new AmmoniumChloride());
        setIngredients(ingredients);
    }
}

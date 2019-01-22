package app.dto.view;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class SoldProductsView {
    @Expose
    private int count;

    @Expose
    private List<ProductNamePriceView> products;

    public SoldProductsView() {
        this.products = new ArrayList<>();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductNamePriceView> getProducts() {
        return products;
    }

    public void setProducts(List<ProductNamePriceView> products) {
        this.products = products;
    }
}

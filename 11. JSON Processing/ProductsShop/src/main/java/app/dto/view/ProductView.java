package app.dto.view;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductView {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private String sellerName;

    public ProductView() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}

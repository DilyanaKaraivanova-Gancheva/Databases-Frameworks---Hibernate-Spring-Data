package product.shop.productshop.models.services.products;

import product.shop.productshop.models.dto.ProductDto;
import product.shop.productshop.models.views.ProductView;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void saveAll(List<ProductDto> productDto);

    List<ProductView> getAllProductsInRange(BigDecimal from, BigDecimal to);
}

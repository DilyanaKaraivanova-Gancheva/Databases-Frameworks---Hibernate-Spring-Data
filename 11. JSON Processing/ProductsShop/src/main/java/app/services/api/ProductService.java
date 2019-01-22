package app.services.api;

import app.dto.binding.ProductDto;
import app.dto.view.ProductView;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void save(ProductDto productDto);

    void saveAll(ProductDto[] products);

    List<ProductView> findAllInPriceRange(BigDecimal from, BigDecimal to);
}

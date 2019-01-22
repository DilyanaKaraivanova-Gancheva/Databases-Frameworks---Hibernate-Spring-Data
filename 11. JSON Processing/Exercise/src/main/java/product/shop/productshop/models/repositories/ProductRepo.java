package product.shop.productshop.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import product.shop.productshop.models.entities.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    List<Product> findByPriceBetweenAndBuyerIdIsNullOrderByPrice(BigDecimal from, BigDecimal to);
}

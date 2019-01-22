package product.shop.productshop.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.shop.productshop.models.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
}

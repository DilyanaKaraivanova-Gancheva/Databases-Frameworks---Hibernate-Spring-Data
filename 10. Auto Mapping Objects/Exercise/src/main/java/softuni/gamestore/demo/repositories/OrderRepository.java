package softuni.gamestore.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.gamestore.demo.models.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
}

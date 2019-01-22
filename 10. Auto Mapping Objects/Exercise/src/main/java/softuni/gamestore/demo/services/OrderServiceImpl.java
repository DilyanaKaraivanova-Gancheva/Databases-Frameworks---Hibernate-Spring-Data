package softuni.gamestore.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.gamestore.demo.models.entities.Order;
import softuni.gamestore.demo.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void add(Order order) {
        this.orderRepository.save(order);
    }
}

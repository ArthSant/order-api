package restaurant.order_api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.order_api.model.dto.OrderDTO;
import restaurant.order_api.model.entity.Order;
import restaurant.order_api.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

   public void createOrder(OrderDTO dto) {
       orderRepository.save(new Order(dto));
   }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    public Order findById(Long id) {
        return orderRepository.getReferenceById(id);
    }
}

package restaurant.order_api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurant.order_api.model.dto.OrderDTO;
import restaurant.order_api.model.entity.Order;
import restaurant.order_api.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity createOrder(@RequestBody @Valid OrderDTO dto) {
        orderService.createOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new OrderDTO(orderService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll() {
        List<Order> allOrders = orderService.findAll();
        return ResponseEntity.ok(allOrders.stream().map(OrderDTO :: new).toList());
    }
}

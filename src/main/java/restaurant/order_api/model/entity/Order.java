package restaurant.order_api.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import restaurant.order_api.model.dto.OrderDTO;
import restaurant.order_api.util.OrderStatus;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Long> itens = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Double total;

    public Order(OrderDTO dto) {
        this.itens.addAll(dto.itens());
        this.status = OrderStatus.RECEIVED;
        this.total = dto.total();
    }

}

package restaurant.order_api.model.dto;

import restaurant.order_api.model.entity.Order;

import java.util.List;

public record OrderDTO(List<Long> itens, String status, double total) {

    public OrderDTO(Order order) {
        this(order.getItens(),order.getStatus().toString(), order.getTotal());
    }
}



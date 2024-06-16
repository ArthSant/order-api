package restaurant.order_api.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.order_api.model.entity.Order;


@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order,Long> {
}

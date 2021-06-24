package anchit.bhushan.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import anchit.bhushan.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}

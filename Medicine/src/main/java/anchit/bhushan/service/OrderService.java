package anchit.bhushan.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import anchit.bhushan.DAO.MedicineRepository;
import anchit.bhushan.DAO.OrderRepository;
import anchit.bhushan.DAO.OrderSpecRepository;
import anchit.bhushan.Model.Order;
import anchit.bhushan.Model.OrderSpec;

@Service
@Transactional
public class OrderService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private OrderSpecRepository orderSpecRepo;
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MedicineRepository medicineRepository;

	

    public List<Integer> orderMedicines(List<OrderSpec> toBeOrderedMedicines) {

        List<Integer> res = new ArrayList<Integer>();
        Order order = orderRepository.save(new Order(1));
        
        for (OrderSpec orderSpec : toBeOrderedMedicines) {
        	orderSpec.setOrder_id(order.getOrder_id());
        	System.out.println(order.getOrder_id());
            medicineRepository.UpdateQuantity(orderSpec.getQuantity(), orderSpec.getC_unique_id());
            orderSpecRepo.save(orderSpec);
            res.add(orderSpec.getC_unique_id());
        }
        return res;
    }

}

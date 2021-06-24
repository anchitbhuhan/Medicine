package anchit.bhushan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import anchit.bhushan.Model.OrderSpec;
import anchit.bhushan.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.POST, value = "/medicine/placeorder")
	public List<Integer> placeOrder(@RequestBody List<OrderSpec> toBeOrdered) {

		return orderService.orderMedicines(toBeOrdered);
	}
}

package br.starstore.api.modules.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.starstore.api.dto.OrderDTO;
import br.starstore.api.entities.ItemOrder;


@RestController
public class OrderController {
	@Autowired
	private OrderService service;

	
	@PostMapping("/order")
	@ResponseBody
	public OrderDTO createPayments(@RequestBody OrderDTO payment) {
		return this.service.createOrder(payment);

	}

	@GetMapping("/order/{clientId}")
	@ResponseBody
	public List<ItemOrder> getAllOrders(@PathVariable("user_id") int user_id) {
		return this.service.findAllItemOrder(user_id);
	}

	
	
}

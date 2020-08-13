package br.starstore.api.modules.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.starstore.api.dto.OrderDTO;
import br.starstore.api.entities.ItemOrder;
import br.starstore.api.entities.ProductsOrder;

@Service
public class OrderService {

	@Autowired
	private ItemOrderRepository itemRepository;
	@Autowired 
	private OrderRepository orderRepository;
	
	public OrderDTO createOrder(OrderDTO order){
		ProductsOrder productsorder = orderRepository.save(order.getProducts());
		List<ItemOrder> items = itemRepository.saveAll(order.getItems());
		OrderDTO orderdto = new OrderDTO(productsorder.getUser_id(), items);
		return orderdto;
	}
	
	public List<ItemOrder> findAllItemOrder(int user_id){
		return itemRepository.findAllListItems(user_id);
	}
	
	
	
	
	
}

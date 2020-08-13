package br.starstore.api.modules.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.starstore.api.entities.ItemOrder;


public interface ItemOrderRepository extends JpaRepository<ItemOrder,Integer>{
	@Query("select item.product_id, item.order_id, item.qtde" 		+ 
			"from ItemOrder item" 									+ 
			"inner join Order order" 								+ 
			"on item.order_id = order.order_id" 					+ 
			"where order.user_id = %:user_id%")
	public List<ItemOrder> findAllListItems(int user_id);
		
	
}

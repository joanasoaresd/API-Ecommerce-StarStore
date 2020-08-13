package br.starstore.api.modules.order;

import org.springframework.data.jpa.repository.JpaRepository;

import br.starstore.api.entities.ProductsOrder;

public interface OrderRepository extends JpaRepository<ProductsOrder,Integer>{
	
}

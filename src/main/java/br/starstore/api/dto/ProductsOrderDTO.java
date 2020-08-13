package br.starstore.api.dto;

import br.starstore.api.entities.ProductsOrder;

public class ProductsOrderDTO extends ProductsOrder{ 
	public ProductsOrderDTO(int i) {
		super(i);
	}

	private int order_id;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
}

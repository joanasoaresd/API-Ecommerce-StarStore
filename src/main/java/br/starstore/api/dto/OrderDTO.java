package br.starstore.api.dto;

import java.util.List;

import br.starstore.api.entities.ItemOrder;
import br.starstore.api.entities.ProductsOrder;

public class OrderDTO {

	private  ProductsOrder products;
	private List<ItemOrder> items;
	
	public OrderDTO(int client_id, List<ItemOrder> items) {
		super();
		this.items = items;
	}

	public List<ItemOrder> getItems() {
		return items;
	}

	public void setItems(List<ItemOrder> items) {
		this.items = items;
	}

	public ProductsOrder getProducts() {
		return products;
	}

	public void setProducts(ProductsOrderDTO products) {
		this.products = products;
	}
	
}

package br.starstore.api.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.starstore.api.dto.ProductsOrderDTO;

@Entity
@Table(name = "producst_order")
public class ProductsOrder{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int order_id;
	
	private int user_id;
	@OneToMany
    @JoinColumn(name = "order_id")
	private List<ItemOrder> item_order;
	 
	
	
	public ProductsOrder(int i) {
		this.item_order = new ArrayList<>();
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}

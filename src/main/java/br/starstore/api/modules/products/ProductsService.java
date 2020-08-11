package br.starstore.api.modules.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.starstore.api.entities.Products;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository repository;

	public Products save(Products product) {
		return this.repository.save(product);
	}

	public List<Products> listAllProducts() {
		return this.repository.findAll();
	}

	public Optional<Products> getProductsById(int id) {
		return this.repository.findById(id);
	}

}

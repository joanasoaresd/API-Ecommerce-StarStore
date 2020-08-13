package br.starstore.api.modules.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.starstore.api.entities.Products;

@RestController
public class ProductsController {

	@Autowired
	private ProductsService service;

	@GetMapping("/products")
	@ResponseBody
	public List<Products> getAllusers() {
		return this.service.listAllProducts();
	}

	@PostMapping("/products")
	@ResponseBody
	public Products createUser(@RequestBody Products user) {
		return this.service.save(user);

	}

	@GetMapping("/products/{id}")
	@ResponseBody
	public Optional<Products> getProductsById(@PathVariable("id") int id) {
		return this.service.getProductsById(id);

	}

}

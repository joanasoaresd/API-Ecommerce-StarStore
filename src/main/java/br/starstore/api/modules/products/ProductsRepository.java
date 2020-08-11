package br.starstore.api.modules.products;

import org.springframework.data.jpa.repository.JpaRepository;

import br.starstore.api.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}

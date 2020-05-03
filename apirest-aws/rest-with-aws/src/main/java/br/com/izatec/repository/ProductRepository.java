package br.com.izatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.izatec.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}

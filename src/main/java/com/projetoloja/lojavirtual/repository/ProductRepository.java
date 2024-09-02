package com.projetoloja.lojavirtual.repository;

import com.projetoloja.lojavirtual.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {





}

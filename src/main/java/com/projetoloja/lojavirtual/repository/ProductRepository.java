package com.projetoloja.lojavirtual.repository;

import com.projetoloja.lojavirtual.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {


    @Query ("SELECT obj FROM com.projetoloja.lojavirtual.model.Product obj WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :productName, '%'))")
     Page<Product> searchProductByName(String productName, Pageable p);





}

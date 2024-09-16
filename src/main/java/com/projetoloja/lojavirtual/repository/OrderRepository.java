package com.projetoloja.lojavirtual.repository;

import com.projetoloja.lojavirtual.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {





}

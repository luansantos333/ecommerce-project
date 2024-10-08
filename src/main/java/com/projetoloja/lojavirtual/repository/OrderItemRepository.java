package com.projetoloja.lojavirtual.repository;

import com.projetoloja.lojavirtual.model.OrderItem;
import com.projetoloja.lojavirtual.model.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}

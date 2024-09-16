package com.projetoloja.lojavirtual.service;

import com.projetoloja.lojavirtual.dto.OrderDTO;
import com.projetoloja.lojavirtual.model.Order;
import com.projetoloja.lojavirtual.repository.OrderRepository;
import com.projetoloja.lojavirtual.service.exceptions.ElementNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) throws ElementNotFoundException {

        Optional<Order> result = orderRepository.findById(id);
        Order o = result.orElseThrow(() -> new ElementNotFoundException("Recurso não encontrado"));
        return new OrderDTO(o);
    }




}

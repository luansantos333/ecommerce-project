package com.projetoloja.lojavirtual.controllers;

import com.projetoloja.lojavirtual.dto.OrderDTO;
import com.projetoloja.lojavirtual.service.OrderService;
import com.projetoloja.lojavirtual.service.exceptions.ElementNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@Valid @PathVariable(name = "id") Long id) throws ElementNotFoundException {

        OrderDTO p = orderService.findById(id);

        return ResponseEntity.ok(p);

    }


}

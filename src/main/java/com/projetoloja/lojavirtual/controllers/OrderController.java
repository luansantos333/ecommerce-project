package com.projetoloja.lojavirtual.controllers;

import com.projetoloja.lojavirtual.dto.OrderDTO;
import com.projetoloja.lojavirtual.service.OrderService;
import com.projetoloja.lojavirtual.service.exceptions.ElementNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable(name = "id") Long id) throws ElementNotFoundException {
        OrderDTO p = orderService.findById(id);
        return ResponseEntity.ok(p);

    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<OrderDTO> insertOrder (@Valid @RequestBody OrderDTO dto) {
        OrderDTO o = orderService.insertOrder(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(o.getId()).toUri();
        return ResponseEntity.created(uri).body(o);
    }


}

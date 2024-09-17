package com.projetoloja.lojavirtual.controllers;

import com.projetoloja.lojavirtual.dto.CategoryDTO;
import com.projetoloja.lojavirtual.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/categories")
public class CategoryController {

    private final CategoryService service;


    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping

    public ResponseEntity<List<CategoryDTO>> findAllCategories () {
        return ResponseEntity.ok(service.allCategories());
    }





}

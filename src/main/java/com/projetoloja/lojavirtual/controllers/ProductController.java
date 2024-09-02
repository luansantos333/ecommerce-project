package com.projetoloja.lojavirtual.controllers;

import com.projetoloja.lojavirtual.dto.ProductDTO;
import com.projetoloja.lojavirtual.model.Product;
import com.projetoloja.lojavirtual.repository.ProductRepository;
import com.projetoloja.lojavirtual.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/products")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping (value = "/{id}")
    public ProductDTO findById (@PathVariable (name = "id") Long id) {

        return productService.findById(id);

    }

    @GetMapping
    public List<ProductDTO> findAll () {

        return productService.findAll();

    }

}

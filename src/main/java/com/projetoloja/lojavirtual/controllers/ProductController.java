package com.projetoloja.lojavirtual.controllers;

import com.projetoloja.lojavirtual.dto.ProductDTO;
import com.projetoloja.lojavirtual.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    public Page<ProductDTO> findAll (Pageable pageable) {
        return productService.findAll(pageable);
    }

    @PostMapping
    public ProductDTO addNewProduct (@RequestBody ProductDTO dto) {

        return productService.addNewProduct(dto);

    }

}

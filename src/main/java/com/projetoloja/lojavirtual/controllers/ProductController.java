package com.projetoloja.lojavirtual.controllers;

import com.projetoloja.lojavirtual.dto.ProductDTO;
import com.projetoloja.lojavirtual.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping (value = "/products")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping (value = "/{id}")
    public ResponseEntity<ProductDTO> findById (@PathVariable (name = "id") Long id) {

        ProductDTO p = productService.findById(id);

        return ResponseEntity.ok(p);

    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll (Pageable pageable) {

        Page<ProductDTO> all = productService.findAll(pageable);
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addNewProduct (@RequestBody ProductDTO dto) {

        ProductDTO p = productService.addNewProduct(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(uri).body(p);

    }

}

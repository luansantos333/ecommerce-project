package com.projetoloja.lojavirtual.controllers;

import com.projetoloja.lojavirtual.dto.ProductDTO;
import com.projetoloja.lojavirtual.service.ProductService;
import com.projetoloja.lojavirtual.service.exceptions.DatabaseException;
import com.projetoloja.lojavirtual.service.exceptions.ElementNotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable(name = "id") Long id) throws ElementNotFoundException {

        ProductDTO p = productService.findById(id);

        return ResponseEntity.ok(p);

    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {

        Page<ProductDTO> all = productService.findAll(pageable);
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addNewProduct(@Valid @RequestBody ProductDTO dto) {

        ProductDTO p = productService.addNewProduct(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(uri).body(p);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@Valid @PathVariable(value = "id") Long id, @RequestBody ProductDTO p) {
        productService.updateProduct(id, p);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable(value = "id") Long id) throws DatabaseException {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();

    }

}

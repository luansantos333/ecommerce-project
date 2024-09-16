package com.projetoloja.lojavirtual.controllers;

import com.projetoloja.lojavirtual.dto.ProducMinDTO;
import com.projetoloja.lojavirtual.dto.ProductDTO;
import com.projetoloja.lojavirtual.service.ProductService;
import com.projetoloja.lojavirtual.service.exceptions.DatabaseException;
import com.projetoloja.lojavirtual.service.exceptions.ElementNotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole ('ROLE_CLIENT')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@Valid @PathVariable(name = "id") Long id) throws ElementNotFoundException {

        ProductDTO p = productService.findById(id);

        return ResponseEntity.ok(p);

    }


    @GetMapping
    public ResponseEntity<Page<ProducMinDTO>> findAll(@RequestParam(name = "productName", defaultValue = "") String productName, Pageable pageable) {

        Page<ProducMinDTO> all = productService.findAll(productName, pageable);
        return ResponseEntity.ok(all);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ProductDTO> addNewProduct(@Valid @RequestBody ProductDTO dto) {

        ProductDTO p = productService.addNewProduct(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(uri).body(p);


    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@Valid @PathVariable(value = "id") Long id, @RequestBody ProductDTO p) {
        productService.updateProduct(id, p);
        return ResponseEntity.ok(p);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN'")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable(value = "id") Long id) throws DatabaseException {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();

    }


}

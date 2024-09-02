package com.projetoloja.lojavirtual.service;

import com.projetoloja.lojavirtual.model.Product;
import com.projetoloja.lojavirtual.repository.ProductRepository;
import org.springframework.stereotype.Service;
import com.projetoloja.lojavirtual.dto.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @Transactional (readOnly = true)
    public ProductDTO findById (Long id) {

        Optional<Product> result = productRepository.findById(id);
        Product p = result.get();
        ProductDTO dto = new ProductDTO(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getImageURI());
        return dto;
    }


    public List<ProductDTO> findAll () {
        List<Product> p = productRepository.findAll();
        return p.stream().map(ProductDTO::new).toList();
    }




}

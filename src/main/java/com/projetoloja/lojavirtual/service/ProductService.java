package com.projetoloja.lojavirtual.service;

import com.projetoloja.lojavirtual.dto.ProductDTO;
import com.projetoloja.lojavirtual.model.Product;
import com.projetoloja.lojavirtual.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional (readOnly = true)
    public Page<ProductDTO> findAll (Pageable pageable) {
        Page<Product> p = productRepository.findAll(pageable);
        return p.map(ProductDTO::new);
    }

    @Transactional
    public ProductDTO addNewProduct (ProductDTO p) {

        Product entity = new Product(p);
        entity = productRepository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO updateProduct (Long id, ProductDTO p) {

        Product entity = productRepository.getReferenceById(id);

        copyDTOToEntity(entity, p);

        entity = productRepository.save(entity);

        return new ProductDTO(entity);

    }

    private void  copyDTOToEntity (Product entity, ProductDTO p) {

        entity.setName(p.getName());
        entity.setDescription(p.getDescription());
        entity.setImageURI(p.getImgUrl());
        entity.setPrice(p.getPrice());
    }



}

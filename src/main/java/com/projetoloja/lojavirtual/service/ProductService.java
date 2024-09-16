package com.projetoloja.lojavirtual.service;

import com.projetoloja.lojavirtual.dto.CategoryDTO;
import com.projetoloja.lojavirtual.dto.ProducMinDTO;
import com.projetoloja.lojavirtual.dto.ProductDTO;
import com.projetoloja.lojavirtual.model.Category;
import com.projetoloja.lojavirtual.model.Product;
import com.projetoloja.lojavirtual.repository.ProductRepository;
import com.projetoloja.lojavirtual.service.exceptions.DatabaseException;
import com.projetoloja.lojavirtual.service.exceptions.ElementNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) throws ElementNotFoundException {

        Optional<Product> result = productRepository.findById(id);
        Product p = result.orElseThrow(() -> new ElementNotFoundException("Recurso não encontrado"));
        return new ProductDTO(p);
    }

    @Transactional(readOnly = true)
    public Page<ProducMinDTO> findAll(String productName, Pageable pageable) {
        Page<Product> p = productRepository.searchProductByName(productName, pageable);
        Page<ProducMinDTO> dto = p.map(x -> new ProducMinDTO(x));
        return dto;

    }


    @Transactional
    public ProductDTO addNewProduct(ProductDTO p) {

        Product entity = new Product(p);
        entity = productRepository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO updateProduct(Long id, ProductDTO p) {

        try {
            Product entity = productRepository.getReferenceById(id);
            copyDTOToEntity(entity, p);
            entity = productRepository.save(entity);
            return new ProductDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException("Recurso não encontrado");
        }

    }


    @Transactional (propagation = Propagation.SUPPORTS)
    public void deleteProduct(Long id) throws DatabaseException {
        if (!productRepository.existsById(id)) {
            throw new ElementNotFoundException("Recurso não encontrado");
        }
        try {
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha na integridade relacional");
        }

    }


    private void copyDTOToEntity(Product entity, ProductDTO p) {

        entity.setName(p.getName());
        entity.setDescription(p.getDescription());
        entity.setImageURI(p.getImgUrl());
        entity.setPrice(p.getPrice());

        entity.getCategories().clear();

        for (CategoryDTO c : p.getCategories()) {

            Category catEntity = new Category();
            catEntity.setId(c.getId());
            entity.getCategories().add(catEntity);

        }
    }


}

package com.projetoloja.lojavirtual.service;

import com.projetoloja.lojavirtual.dto.CategoryDTO;
import com.projetoloja.lojavirtual.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Transactional (readOnly = true)
    public List<CategoryDTO> allCategories () {

      return categoryRepository.findAll().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());

    }



}

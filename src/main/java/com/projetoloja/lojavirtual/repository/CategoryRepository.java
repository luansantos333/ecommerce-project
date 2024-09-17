package com.projetoloja.lojavirtual.repository;

import com.projetoloja.lojavirtual.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {





}

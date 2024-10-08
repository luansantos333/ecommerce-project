package com.projetoloja.lojavirtual.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity (name = "tb_category")
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany (mappedBy = "categories")
    private Set<Product> products = new HashSet<>();


    public Category() {
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Category category = (Category) object;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.projetoloja.lojavirtual.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity (name = "tb_product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column (columnDefinition = "TEXT")
    private String description;
    private Double price;
    private String imgUrl;
    @ManyToMany
    @JoinTable (name = "tb_product_category", joinColumns = @JoinColumn (name = "product_id"),
            inverseJoinColumns = @JoinColumn (name = "category_id"))
    private Set<Category> categories = new HashSet<>();
    @OneToMany (mappedBy = "id.product")
    private Set<OrderItem> orderItemSet = new HashSet<>();

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public Product(long id, String name, String description, double price, String imageURI) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imageURI;
    }

    public Product() {
    }


    public Set<Category> getCategories() {
        return categories;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageURI() {
        return imgUrl;
    }

    public void setImageURI(String imageURI) {
        this.imgUrl = imageURI;
    }


    public List<Order> getOrderList () {


        return orderItemSet.stream().map(x -> x.getOrder()).toList();

    }

}

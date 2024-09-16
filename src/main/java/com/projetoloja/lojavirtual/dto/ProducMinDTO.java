package com.projetoloja.lojavirtual.dto;

import com.projetoloja.lojavirtual.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProducMinDTO {

    private Long id;
    private String name;
    private Double price;
    private String imgUrl;


    public ProducMinDTO() {
    }

    public ProducMinDTO(Long id, String name, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
    }


    public ProducMinDTO(Product product) {

        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        imgUrl  = product.getImageURI();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}

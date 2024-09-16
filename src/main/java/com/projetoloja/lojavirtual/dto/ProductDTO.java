package com.projetoloja.lojavirtual.dto;

import com.projetoloja.lojavirtual.model.Category;
import com.projetoloja.lojavirtual.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private Long id;
    @Size(message = "O campo deve ter entre 3 e 80 caracteres!", min = 3, max = 80)
    @NotBlank(message = "O campo nome está em branco!")
    private String name;
    @NotBlank(message = "A descrição não pode estar vazia!")
    @Size(message = "A descrição deve ter no mínimo 10 caracteres!", min = 10)
    private String description;
    @Positive(message = "O preço deve ser maior que zero!")
    private Double price;
    private String imgUrl;
    @NotEmpty (message = "O produto deve ter pelo menos uma categoria!")
    List<CategoryDTO> categories = new ArrayList<>();


    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl, List<CategoryDTO> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.categories = categories;
    }


    public ProductDTO(Product product) {

        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImageURI();

        for (Category c : product.getCategories()) {
            categories.add(new CategoryDTO(c));
        }
    }


    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}

package com.projetoloja.lojavirtual.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class OrderItem {

    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();
    private int quantity;
    private double price;


    public OrderItem() {
    }

    public OrderItem(Order order, Product product, int quantity, double price) {
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder () {

        return this.id.getOrder();

    }

    public void setOrder (Order o) {

        this.id.setOrder(o);

    }


    public Product getProduct () {

        return this.id.getProduct();

    }

    public void setProduct (Product p) {

        this.id.setProduct(p);

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

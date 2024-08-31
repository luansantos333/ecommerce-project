package com.projetoloja.lojavirtual.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity (name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private OrderStatus status;
    @ManyToOne
    @JoinColumn (name = "client_id")
    private User client;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;
    @OneToMany (mappedBy = "id.order")
    Set<OrderItem> orderItemSet = new HashSet<>();





    public Order() {
    }

    public Order(long id, Instant moment, OrderStatus orderStatus, User client, Payment payment) {
        this.id = id;
        this.moment = moment;
        this.status = orderStatus;
        this.client = client;
        this.payment = payment;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Order order = (Order) object;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return status;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.status = orderStatus;
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }


    public List<Product> getProducts () {

        return orderItemSet.stream().map(x -> x.getProduct()).toList();
    }


}

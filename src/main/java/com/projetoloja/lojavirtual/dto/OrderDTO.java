package com.projetoloja.lojavirtual.dto;

import com.projetoloja.lojavirtual.model.Order;
import com.projetoloja.lojavirtual.model.OrderItem;
import com.projetoloja.lojavirtual.model.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;
    private PaymentDTO paymentDTO;

    private ClientDTO clientDTO;
    @NotEmpty
    private List<OrderItemDTO> orderItems = new ArrayList<>();
    private Double total;


    public OrderDTO(Long id, Instant moment, OrderStatus status, PaymentDTO paymentDTO, ClientDTO clientDTO, List<OrderItemDTO> orderItems, Double total) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.paymentDTO = paymentDTO;
        this.clientDTO = clientDTO;
        this.orderItems = orderItems;
        this.total = total;
    }

    public OrderDTO(Order entity) {


        id = entity.getId();
        moment = entity.getMoment();
        status = entity.getOrderStatus();
        paymentDTO = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
        clientDTO = new ClientDTO(entity.getClient());


        for (OrderItem o : entity.getOrderItemSet()) {

            orderItems.add(new OrderItemDTO(o));

        }


        total = getTotal();

    }


    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public PaymentDTO getPaymentDTO() {
        return paymentDTO;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }


    public Double getTotal() {

        total = 0.0;

        double[] array = orderItems.stream().mapToDouble(OrderItemDTO::getSubTotal).toArray();

        for (int i = 0; i < array.length; i++) {

            total += array[i];
        }

        return total;

    }
}

package com.projetoloja.lojavirtual.dto;

import com.projetoloja.lojavirtual.model.Order;
import com.projetoloja.lojavirtual.model.OrderItem;
import com.projetoloja.lojavirtual.model.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;
    private PaymentDTO payment;

    private ClientDTO client;
    @NotEmpty (message = "Deve haver pelo menos um item no pedido!")
    private List<OrderItemDTO> itens = new ArrayList<>();
    private Double total;


    public OrderDTO(Long id, Instant moment, OrderStatus status, PaymentDTO paymentDTO, ClientDTO clientDTO, List<OrderItemDTO> itens, Double total) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.payment = paymentDTO;
        this.client = clientDTO;
        this.itens = itens;
        this.total = total;
    }





    public OrderDTO(Order entity) {


        id = entity.getId();
        moment = entity.getMoment();
        status = entity.getOrderStatus();
        payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
        client = new ClientDTO(entity.getClient());


        for (OrderItem o : entity.getOrderItemSet()) {

            itens.add(new OrderItemDTO(o));

        }


        total = getTotal();

    }


    public ClientDTO getClient() {
        return client;
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

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItens() {
        return itens;
    }


    public Double getTotal() {

        total = 0.0;

        double[] array = itens.stream().mapToDouble(OrderItemDTO::getSubTotal).toArray();

        for (int i = 0; i < array.length; i++) {

            total += array[i];
        }

        return total;

    }
}

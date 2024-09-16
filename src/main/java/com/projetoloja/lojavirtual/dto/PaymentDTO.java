package com.projetoloja.lojavirtual.dto;

import com.projetoloja.lojavirtual.model.Payment;

import java.time.Instant;

public class PaymentDTO {

    private long id;
    private Instant moment;


    public PaymentDTO(long id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }

    public PaymentDTO (Payment payment) {

        id = payment.getId();
        moment = payment.getMoment();
    }

    public long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }
}

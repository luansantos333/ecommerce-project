package com.projetoloja.lojavirtual.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity (name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (unique = true)
    private String name;
    private String email;
    private String phone;
    private LocalDate birth_date;
    private String password;
    //private String[] roles;
    @OneToMany (mappedBy = "client")
    private List<Order> orders = new ArrayList<>();





    public User() {
    }


    public User(long id, String name, String email, String phone, LocalDate bithday, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birth_date = bithday;
        this.password = password;
    }



    public List<Order> getOrders() {
        return orders;
    }



    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone) && Objects.equals(birth_date, user.birth_date) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, birth_date, password);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBithday() {
        return birth_date;
    }

    public void setBithday(LocalDate bithday) {
        this.birth_date = bithday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

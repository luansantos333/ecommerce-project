package com.projetoloja.lojavirtual.dto;

import com.projetoloja.lojavirtual.model.Order;
import com.projetoloja.lojavirtual.model.Role;
import com.projetoloja.lojavirtual.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birth_date;

    private List<String> roles = new ArrayList<>();


    public UserDTO(long id, String name, String email, String phone, LocalDate birth_date, List<Order> orders, List<String> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birth_date = birth_date;
        this.roles = roles;
    }


    public UserDTO() {
    }


    public UserDTO (User user) {

        id = user.getId();
        name = user.getName();
        email = user.getUsername();
        phone = user.getPhone();
        birth_date = user.getBithday();

        for (Role r : user.getRoles()) {

            roles.add(r.getAuthority());
        }

    }



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }


    public List<String> getRoles() {
        return roles;
    }
}

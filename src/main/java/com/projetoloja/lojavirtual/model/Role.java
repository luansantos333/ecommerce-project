package com.projetoloja.lojavirtual.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity
@Table (name = "tb_roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    public Role(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }


    public Role() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

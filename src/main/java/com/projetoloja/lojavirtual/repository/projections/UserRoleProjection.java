package com.projetoloja.lojavirtual.repository.projections;

public interface UserRoleProjection {
    String getUsername();

    String getPassword();

    Long getRoleId();

    String getAuthority();

}

package com.projetoloja.lojavirtual.repository;

import com.projetoloja.lojavirtual.model.User;
import com.projetoloja.lojavirtual.repository.projections.UserRoleProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {


   @Query(nativeQuery = true, value = "SELECT u.email AS username, u.password, roles.id AS roleId, roles.authority FROM tb_user AS u" +
           " INNER JOIN tb_user_role AS user_role ON u.id = user_role.user_id INNER JOIN tb_roles AS roles ON user_role.role_id = roles.id WHERE u.email = :email")
    List<UserRoleProjection> searchUserRolesPasswordByEmail(String email);


}

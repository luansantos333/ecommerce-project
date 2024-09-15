package com.projetoloja.lojavirtual.service;

import com.projetoloja.lojavirtual.model.Role;
import com.projetoloja.lojavirtual.model.User;
import com.projetoloja.lojavirtual.repository.UserRepository;
import com.projetoloja.lojavirtual.repository.projections.UserRoleProjection;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserService implements UserDetailsService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserRoleProjection> users = repository.searchUserRolesPasswordByEmail(username);

        if (users.size() == 0) {


            throw new UsernameNotFoundException("Could not found any user with the username informed");

        }

        User user = new User();
        user.setEmail(users.get(0).getUsername());
        user.setPassword(users.get(0).getPassword());


        for (UserRoleProjection u : users) {


            user.addRole(new Role(u.getRoleId(), u.getAuthority()));

        }


        return user;

    }
}

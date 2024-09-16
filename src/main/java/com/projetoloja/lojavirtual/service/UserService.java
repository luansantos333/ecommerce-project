package com.projetoloja.lojavirtual.service;

import com.projetoloja.lojavirtual.dto.UserDTO;
import com.projetoloja.lojavirtual.model.Role;
import com.projetoloja.lojavirtual.model.User;
import com.projetoloja.lojavirtual.repository.UserRepository;
import com.projetoloja.lojavirtual.repository.projections.UserRoleProjection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

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


    @Transactional(readOnly = true)
    protected User authenticated() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //pega a autenticação no contexto de segurança
        Jwt jwtPrincipal = (Jwt) authentication.getPrincipal(); //pega o token JWT
        String usernameClaim = jwtPrincipal.getClaim("username"); // passa o usuário associado na claim username dentro do token para uma String

        User user = repository.findByEmail(usernameClaim).orElseThrow(() -> new UsernameNotFoundException("Não foi possível encontrar " +
                "o usuário com o email informado"));

        return user;
    }


    public UserDTO getUserAuthenticatedDTO () {
        User authenticated = authenticated();
        return new UserDTO(authenticated);
    }



}

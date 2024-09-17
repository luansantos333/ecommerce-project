package com.projetoloja.lojavirtual.service;

import com.projetoloja.lojavirtual.model.User;
import com.projetoloja.lojavirtual.repository.UserRepository;
import com.projetoloja.lojavirtual.service.exceptions.ForbidenException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    private final UserService service;


    public AuthService(UserService service) {
        this.service = service;
    }

    public void validateSelfOrAdmin (Long clientId) {

            User me = service.authenticated();
            if (!me.hasRole("ROLE_ADMIN") && me.getId() != clientId) {


                throw new ForbidenException("Usuário não tem permissão para acessar esse pedido!");


            }


    }


}

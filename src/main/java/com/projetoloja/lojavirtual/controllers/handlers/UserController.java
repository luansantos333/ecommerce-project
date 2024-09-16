package com.projetoloja.lojavirtual.controllers.handlers;

import com.projetoloja.lojavirtual.dto.UserDTO;
import com.projetoloja.lojavirtual.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping ("/me")
    public ResponseEntity<UserDTO> getMe () {
        UserDTO userAuthenticatedDTO = userService.getUserAuthenticatedDTO();
        return ResponseEntity.ok(userAuthenticatedDTO);

    }


}

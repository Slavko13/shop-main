package ru.shop.oauthserver.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.shop.base.globalDTO.JwtAuthenticationResponse;
import ru.shop.base.globalDTO.LoginDTO;
import ru.shop.dbtools.models.user.AuthoritiesEnum;
import ru.shop.dbtools.models.user.Role;
import ru.shop.dbtools.repositories.RoleRepo;
import ru.shop.oauthserver.services.AuthService;

import java.util.Set;

@Controller
public class AuthController {



    private final RoleRepo roleRepo;

    private final AuthService authService;

    public AuthController(RoleRepo roleRepo, AuthService authService) {
        this.roleRepo = roleRepo;
        this.authService = authService;
    }

    @PostMapping("/auth")
    @CrossOrigin
    public ResponseEntity<JwtAuthenticationResponse> authenticateUser(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.signIn(loginDTO));
    }


    @GetMapping("/auth/roles")
    public void saveRoles() {
        roleRepo.save(new Role("ROLE_GUEST", "Обычный недопользователь", Set.of(AuthoritiesEnum.NOT_ACTIVE)));
        roleRepo.save(new Role("ROLE_ADMIN", "Обычный админ", Set.of(AuthoritiesEnum.FULL_ACCESS)));
        roleRepo.save(new Role("ROLE_BUYER", "Обычный покупатель", Set.of(AuthoritiesEnum.BUYER)));
    }

    @GetMapping("/auth/huth")
    public String huth() {
        return "huth";

    }

}
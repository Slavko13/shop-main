package ru.shop.oauthserver.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.shop.base.globalDTO.JwtAuthenticationResponse;
import ru.shop.base.globalDTO.LoginDTO;
import ru.shop.oauthserver.services.AuthService;

@Controller
public class AuthController {



    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/login")
    @CrossOrigin
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.signIn(loginDTO));
    }

}
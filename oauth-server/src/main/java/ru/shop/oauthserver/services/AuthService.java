package ru.shop.oauthserver.services;

import ru.shop.base.globalDTO.JwtAuthenticationResponse;
import ru.shop.base.globalDTO.LoginDTO;

import java.util.Map;

public interface AuthService {

    JwtAuthenticationResponse signIn(LoginDTO loginDTO);

}

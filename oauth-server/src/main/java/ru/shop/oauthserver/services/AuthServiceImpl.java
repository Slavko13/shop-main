package ru.shop.oauthserver.services;

import org.springframework.stereotype.Service;
import ru.shop.base.globalDTO.JwtAuthenticationResponse;
import ru.shop.base.globalDTO.LoginDTO;
import ru.shop.dbtools.models.user.AppUser;
import ru.shop.dbtools.services.UserService;
import ru.shop.oauthserver.security.jwt.JwtTokenProvider;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public JwtAuthenticationResponse signIn(LoginDTO loginDTO) {
        AppUser appUser = userService.findByEmail(loginDTO.getPhoneNumberOrEmail());
        String token = jwtTokenProvider.generateToken(appUser.getEmail(), appUser.getRole());
        return new JwtAuthenticationResponse(token);
    }
}

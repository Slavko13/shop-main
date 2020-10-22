package ru.shop.oauthserver.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.shop.base.exceptions.BadRequestException;
import ru.shop.base.exceptions.NotFoundException;
import ru.shop.base.globalDTO.LoginDTO;
import ru.shop.dbtools.models.user.Role;
import ru.shop.dbtools.models.user.User;
import ru.shop.dbtools.services.UserService;
import ru.shop.oauthserver.security.jwt.JwtTokenProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(UserService userService, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Map<Object, Object>  signIn(LoginDTO loginDTO) {

        try {
            String username = loginDTO.getPhoneNumberOrEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginDTO.getPassword()));
            User user = userService.findByEmail(username);

            if (user == null) {
                throw new NotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRole());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return response;
        } catch (AuthenticationException e) {
            throw new BadRequestException("Invalid username or password");
        }

    }
}

package ru.shop.oauthserver.services;

import org.springframework.stereotype.Service;
import ru.shop.base.globalDTO.LoginDTO;
import ru.shop.dbtools.services.UserService;

import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    public AuthServiceImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public Map<Object, Object>  signIn(LoginDTO loginDTO) {

        return null;
    }
}

package ru.shop.accountservice.service;

import ru.shop.accountservice.dto.RegistrationDTO;

import java.util.UUID;

public interface RegistrationService {

    void registration(RegistrationDTO registrationDTO);
    void confirm(UUID confirmCode, String login);


}

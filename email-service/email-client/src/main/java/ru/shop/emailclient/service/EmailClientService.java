package ru.shop.emailclient.service;

import ru.shop.emailclient.dto.EmailDTO;

public interface EmailClientService {

    void sendEmailFromShop(EmailDTO dto);
    void sendEmailFromRegistration(EmailDTO dto);

}

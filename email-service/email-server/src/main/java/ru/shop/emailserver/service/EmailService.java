package ru.shop.emailserver.service;

import ru.shop.emailclient.dto.EmailDTO;

import javax.mail.MessagingException;

public interface EmailService {

    void send(EmailDTO emailDTO) throws MessagingException;


}

package ru.shop.emailclient.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import ru.shop.emailclient.dto.EmailDTO;

public class EmailClientServiceImpl implements EmailClientService {

    @Value("#{getEmailFromShopService.name}")
    private String SEND_EMAIL_SHOP;

    @Value("#{getEmailFromRegistrationService.name}")
    private String SEND_EMAIL_REGISTRATION;

    private final AmqpTemplate amqpTemplate;

    public EmailClientServiceImpl(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }


    @Override
    public void sendEmailFromShop(EmailDTO dto) {
        amqpTemplate.convertAndSend(SEND_EMAIL_SHOP, dto);
    }

    @Override
    public void sendEmailFromRegistration(EmailDTO dto) {
        amqpTemplate.convertAndSend(SEND_EMAIL_REGISTRATION, dto);
    }

}

package ru.shop.emailserver.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;
import ru.shop.emailclient.dto.EmailDTO;
import ru.shop.emailserver.service.EmailService;

@Component
public class EmailConsumer {

    private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "#{getEmailFromRegistrationService.name}")
    public void send(EmailDTO emailDTO) throws MessagingException, javax.mail.MessagingException {
        emailService.send(emailDTO);
    }



}

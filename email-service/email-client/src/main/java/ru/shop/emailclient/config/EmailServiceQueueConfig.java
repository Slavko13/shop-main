package ru.shop.emailclient.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailServiceQueueConfig {

    @Bean
    public Queue getEmailFromRegistrationService() {
        return new Queue("get.email.from.registration.service");
    }

    @Bean
    public Queue getEmailFromShopService() {
        return new Queue("get.email.from.shop.service");
    }



}

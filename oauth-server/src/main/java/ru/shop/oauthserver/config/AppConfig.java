package ru.shop.oauthserver.config;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;
import ru.shop.base.config.BaseConfig;

@SpringBootConfiguration
@Import({BaseConfig.class, HibernateConfig.class, RabbitConfig.class})
public class AppConfig {



}

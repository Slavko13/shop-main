package ru.shop.shopapi.config;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.shop.base.config.BaseConfig;


@SpringBootConfiguration
@Import({HibernateConfig.class, BaseConfig.class})
public class AppConfig {


}

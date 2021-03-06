package ru.shop.accountservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.shop.security.config.CommonSecurityConfig;


@Configuration
@EnableWebSecurity
@Import({CommonSecurityConfig.class})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/registration/**").anonymous()
                .antMatchers(HttpMethod.GET, "/registration/**").anonymous()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}

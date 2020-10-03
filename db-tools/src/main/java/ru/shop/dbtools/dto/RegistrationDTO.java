package ru.shop.dbtools.dto;


import lombok.Data;

@Data
public class RegistrationDTO {

    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;

}

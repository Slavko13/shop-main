package ru.shop.accountservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {

    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

}

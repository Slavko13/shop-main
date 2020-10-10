package ru.shop.accountservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ConfirmCodeDTO {

    private UUID userId;
    private UUID confirmCode;

}

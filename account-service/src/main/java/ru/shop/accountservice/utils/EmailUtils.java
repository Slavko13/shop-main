package ru.shop.accountservice.utils;

import ru.shop.dbtools.models.ConfirmCode;
import ru.shop.emailclient.dto.EmailDTO;

import java.util.Map;

public class EmailUtils {

    public static EmailDTO createEmailToSend(ConfirmCode confirmCode) {
        return EmailDTO.builder()
                .messageTo(confirmCode.getUser().getEmail())
                .template(confirmCode.getAction().name().toLowerCase())
                .subject("Подтверждение регистрации на сайте")
                .content(Map.of("userId", confirmCode.getUser().getId(),
                        "confirmCode", confirmCode.getConfirmCode()))
                .build();
    }

}

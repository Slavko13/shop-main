package ru.shop.dbtools.services;

import ru.shop.dbtools.models.ConfirmCode;
import ru.shop.dbtools.models.user.User;

import java.util.UUID;

public interface ConfirmCodeService {

    ConfirmCode prepareAndSave(User user, ConfirmCode.Action action);
    ConfirmCode findByCode(UUID code);
    void deleteByCode(UUID code);


}

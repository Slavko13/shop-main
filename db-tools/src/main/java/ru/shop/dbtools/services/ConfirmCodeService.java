package ru.shop.dbtools.services;

import ru.shop.dbtools.models.ConfirmCode;
import ru.shop.dbtools.models.user.AppUser;

import java.util.UUID;

public interface ConfirmCodeService {

    ConfirmCode prepareAndSave(AppUser appUser, ConfirmCode.Action action);
    ConfirmCode findByCode(UUID code);
    void deleteByCode(UUID code);


}

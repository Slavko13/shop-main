package ru.shop.dbtools.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shop.base.exceptions.NotFoundException;
import ru.shop.dbtools.models.ConfirmCode;
import ru.shop.dbtools.models.user.AppUser;
import ru.shop.dbtools.repositories.ConfirmCodeRepo;

import java.util.UUID;

@Service
public class ConfirmCodeServiceImpl implements ConfirmCodeService {

    private final ConfirmCodeRepo confirmCodeRepo;

    public ConfirmCodeServiceImpl(ConfirmCodeRepo confirmCodeRepo) {
        this.confirmCodeRepo = confirmCodeRepo;
    }

    @Override
    @Transactional
    public ConfirmCode prepareAndSave(AppUser appUser, ConfirmCode.Action action) {
        ConfirmCode confirmCode =  ConfirmCode.builder()
                .action(action)
                .confirmCode(UUID.randomUUID())
                .appUser(appUser)
                .build();

        return confirmCodeRepo.save(confirmCode);
    }

    @Override
    @Transactional
    public ConfirmCode findByCode(UUID code) {
        return confirmCodeRepo.findById(code).orElseThrow(() -> new NotFoundException("{ConfirmCodeServiceImpl.findByCode.NotFound}"));
    }

    @Override
    @Transactional
    public void deleteByCode(UUID code) {
        confirmCodeRepo.deleteById(code);
    }
}

package ru.shop.dbtools.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shop.base.exceptions.NotFoundException;
import ru.shop.dbtools.models.user.AppUser;
import ru.shop.dbtools.repositories.UserRepo;

import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    @Transactional
    public void saveUser(AppUser appUser) {
        userRepo.save(appUser);
    }

    @Override
    @Transactional
    public AppUser findByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new NotFoundException("{UserServiceImpl.findByEmail.NotFound}"));
    }

    @Override
    @Transactional
    public void deleteUserByEmail(String email) {
        userRepo.deleteUserByEmail(email);
    }

    @Override
    @Transactional
    public AppUser findUserById(UUID userId) {
        return userRepo.findById(userId).orElseThrow(() -> new NotFoundException("{UserServiceImpl.findById.NotFound}") );
    }

    @Override
    @Transactional
    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    @Transactional
    public AppUser findByPhoneNumber(String phoneNumber) {
        return userRepo.findByPhoneNumber(phoneNumber).orElseThrow(() -> new NotFoundException("{UserServiceImpl.findByPhoneNumber.NotFound}")) ;
    }

    @Override
    @Transactional
    public boolean existsByPhoneNumber(String phoneNumber) {
        return userRepo.existsByPhoneNumber(phoneNumber);
    }


}

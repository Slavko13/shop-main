package ru.shop.dbtools.services;

import ru.shop.dbtools.models.user.AppUser;

import java.util.UUID;


public interface UserService {

    void saveUser(AppUser appUser);
    AppUser findByEmail(String email);
    boolean existsByEmail(String email);
    AppUser findByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumber(String phoneNumber);
    AppUser findUserById(UUID userId);
    void deleteUserByEmail(String email);


}

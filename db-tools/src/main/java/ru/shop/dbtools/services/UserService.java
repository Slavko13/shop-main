package ru.shop.dbtools.services;

import ru.shop.dbtools.models.user.User;

import java.util.UUID;


public interface UserService {

    void saveUser(User user);
    User findByEmail(String email);
    boolean existsByEmail(String email);
    User findByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumber(String phoneNumber);
    User findUserById(UUID userId);
    void deleteUserByEmail(String email);


}

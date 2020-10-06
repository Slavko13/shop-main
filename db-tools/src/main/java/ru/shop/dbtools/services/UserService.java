package ru.shop.dbtools.services;

import ru.shop.dbtools.models.user.User;



public interface UserService {

    void saveUser(User user);
    User findByEmail(String email);
    boolean existsByEmail(String email);
    User findByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumber(String phoneNumber);


}

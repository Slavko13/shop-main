package ru.shop.dbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shop.dbtools.models.user.AppUser;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends CrudRepository<AppUser, UUID> {

    Optional<AppUser> findByPhoneNumber(String phoneNumber);
    Optional<AppUser> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    void deleteUserByEmail(String email);

}

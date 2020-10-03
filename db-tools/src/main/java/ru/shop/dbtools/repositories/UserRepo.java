package ru.shop.dbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shop.dbtools.models.user.User;

import java.util.UUID;

@Repository
public interface UserRepo extends CrudRepository<User, UUID> {

}

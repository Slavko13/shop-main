package ru.shop.dbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.shop.dbtools.models.ConfirmCode;

import java.util.UUID;


public interface ConfirmCodeRepo extends CrudRepository<ConfirmCode, UUID> {


}

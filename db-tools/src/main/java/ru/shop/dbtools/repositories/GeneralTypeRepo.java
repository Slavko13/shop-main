package ru.shop.dbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.shop.dbtools.models.goods.GeneralType;

public interface GeneralTypeRepo extends CrudRepository<GeneralType, Long> {
}

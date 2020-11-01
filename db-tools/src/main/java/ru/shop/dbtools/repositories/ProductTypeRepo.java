package ru.shop.dbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.shop.dbtools.models.goods.ProductType;

import java.util.List;

public interface ProductTypeRepo extends CrudRepository<ProductType, Long> {


}

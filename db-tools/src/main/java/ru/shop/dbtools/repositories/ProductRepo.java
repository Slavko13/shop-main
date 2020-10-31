package ru.shop.dbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.shop.dbtools.models.goods.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {


}

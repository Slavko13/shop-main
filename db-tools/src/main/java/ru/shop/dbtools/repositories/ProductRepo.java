package ru.shop.dbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.shop.dbtools.models.goods.Product;
import ru.shop.dbtools.models.goods.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends CrudRepository<Product, Long> {

    List<Product> findAllByProductType(ProductType productType);

}

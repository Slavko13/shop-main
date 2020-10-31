package ru.shop.dbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.shop.dbtools.models.goods.ProductTypeCategory;

public interface ProductTypeCategoryRepo extends CrudRepository<ProductTypeCategory, Long> {

}

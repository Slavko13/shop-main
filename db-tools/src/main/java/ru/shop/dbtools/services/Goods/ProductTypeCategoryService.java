package ru.shop.dbtools.services.Goods;

import ru.shop.dbtools.dto.FilteredCategoriesDTO;
import ru.shop.dbtools.models.goods.ProductTypeCategory;

import java.util.List;

public interface ProductTypeCategoryService {

    List<ProductTypeCategory> getAllCategories();
    List<ProductTypeCategory> getFilteredCategories(FilteredCategoriesDTO filteredCategoriesDTO);

}

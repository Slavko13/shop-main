package ru.shop.shopapi.services.goods;

import ru.shop.dbtools.models.goods.GeneralType;
import ru.shop.dbtools.models.goods.ProductType;
import ru.shop.dbtools.models.goods.ProductTypeCategory;
import ru.shop.shopapi.dto.FilteredGeneralTypeDTO;

import java.util.List;

public interface ProductTypeService {

    List<ProductType> getAllProductsType(ProductTypeCategory productTypeCategory);
    List<ProductType> getFilteredProductsTypes(FilteredGeneralTypeDTO filteredGeneralTypeDTO);
}

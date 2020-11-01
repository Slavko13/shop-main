package ru.shop.shopapi.services.goods;

import org.springframework.transaction.annotation.Transactional;
import ru.shop.dbtools.models.goods.ProductType;
import ru.shop.dbtools.models.goods.ProductTypeCategory;
import ru.shop.dbtools.repositories.ProductTypeRepo;
import ru.shop.shopapi.dto.FilteredGeneralTypeDTO;

import java.util.List;

public class ProductTypeServiceImpl implements ProductTypeService {

    private final ProductTypeRepo productTypeRepo;

    public ProductTypeServiceImpl(ProductTypeRepo productTypeRepo) {
        this.productTypeRepo = productTypeRepo;
    }

    @Override
    @Transactional
    public List<ProductType> getAllProductsType(ProductTypeCategory productTypeCategory) {
        return null;
    }

    @Override
    @Transactional
    public List<ProductType> getFilteredProductsTypes(FilteredGeneralTypeDTO filteredGeneralTypeDTO) {
        return null;
    }
}

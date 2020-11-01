package ru.shop.shopapi.services.goods;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shop.dbtools.repositories.ProductTypeCategoryRepo;
import ru.shop.shopapi.dto.FilteredCategoriesDTO;
import ru.shop.dbtools.models.goods.ProductTypeCategory;

import java.util.List;

@Service
public class ProductTypeCategoryServiceImpl implements ProductTypeCategoryService {

    private final ProductTypeCategoryRepo productTypeCategoryRepo;

    public ProductTypeCategoryServiceImpl(ProductTypeCategoryRepo productTypeCategoryRepo) {
        this.productTypeCategoryRepo = productTypeCategoryRepo;
    }


    @Override
    @Transactional
    public List<ProductTypeCategory> getAllCategories() {
        return (List<ProductTypeCategory>) productTypeCategoryRepo.findAll();
    }

    @Override
    @Transactional
    public List<ProductTypeCategory> getFilteredCategories(FilteredCategoriesDTO filteredCategoriesDTO) {
        return null;
    }

}

package ru.shop.dbtools.services.Goods;

import org.springframework.stereotype.Service;
import ru.shop.dbtools.dto.FilteredCategoriesDTO;
import ru.shop.dbtools.models.goods.ProductTypeCategory;

import java.util.List;

@Service
public class ProductTypeCategoryServiceImpl implements ProductTypeCategoryService {

    @Override
    public List<ProductTypeCategory> getAllCategories() {
        return null;
    }

    @Override
    public List<ProductTypeCategory> getFilteredCategories(FilteredCategoriesDTO filteredCategoriesDTO) {
        return null;
    }

}

package ru.shop.dbtools.services.Goods;

import org.springframework.stereotype.Service;
import ru.shop.dbtools.dto.FilteredProductsDTO;
import ru.shop.dbtools.models.goods.Product;
import ru.shop.dbtools.models.goods.ProductType;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getAllProducts(ProductType productType) {
        return null;
    }

    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> getFilteredProducts(FilteredProductsDTO filteredProductsDTO) {
        return null;
    }
}

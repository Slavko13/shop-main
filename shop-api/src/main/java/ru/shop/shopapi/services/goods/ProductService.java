package ru.shop.shopapi.services.goods;

import ru.shop.shopapi.dto.FilteredProductsDTO;
import ru.shop.dbtools.models.goods.Product;
import ru.shop.dbtools.models.goods.ProductType;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(ProductType productType);
    Product getSingleProduct(Long id);
    List<Product> getFilteredProducts(FilteredProductsDTO filteredProductsDTO);


}

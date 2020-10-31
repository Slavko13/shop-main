package ru.shop.dbtools.services.Goods;

import ru.shop.dbtools.dto.FilteredProductsDTO;
import ru.shop.dbtools.models.goods.Product;
import ru.shop.dbtools.models.goods.ProductType;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(ProductType productType);
    Product getSingleProduct(Long id);
    List<Product> getFilteredProducts(FilteredProductsDTO filteredProductsDTO);


}

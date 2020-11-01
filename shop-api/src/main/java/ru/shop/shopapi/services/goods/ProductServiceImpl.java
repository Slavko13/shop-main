package ru.shop.shopapi.services.goods;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shop.base.exceptions.NotFoundException;
import ru.shop.shopapi.dto.FilteredProductsDTO;
import ru.shop.dbtools.json.views.ProductsViews;
import ru.shop.dbtools.models.goods.Product;
import ru.shop.dbtools.models.goods.ProductType;
import ru.shop.dbtools.repositories.ProductRepo;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    @Transactional
    @JsonView(ProductsViews.ShortInfo.class)
    public List<Product> getAllProducts(ProductType productType) {
        return productRepo.findAllByProductType(productType);
    }

    @Override
    @Transactional
    @JsonView(ProductsViews.SingleInfo.class)
    public Product getSingleProduct(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new NotFoundException("{ProductServiceImpl.getSingleProduct.class}"));
    }

    @Override
    @Transactional
    public List<Product> getFilteredProducts(FilteredProductsDTO filteredProductsDTO) {
        return null;
    }
}

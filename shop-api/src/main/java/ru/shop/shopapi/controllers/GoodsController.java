package ru.shop.shopapi.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shop.dbtools.json.views.ProductTypeViews;
import ru.shop.dbtools.json.views.ProductsViews;
import ru.shop.dbtools.models.goods.GeneralType;
import ru.shop.dbtools.models.goods.Product;
import ru.shop.dbtools.models.goods.ProductType;
import ru.shop.dbtools.models.goods.ProductTypeCategory;
import ru.shop.shopapi.services.goods.GeneralTypeService;
import ru.shop.shopapi.services.goods.ProductService;
import ru.shop.shopapi.services.goods.ProductTypeCategoryService;

import java.util.List;

@RestController
@RequestMapping("/shop/products")
public class GoodsController {

    private final GeneralTypeService generalTypeService;
    private final ProductService productService;
    private final ProductTypeCategoryService productTypeCategoryService;


    public GoodsController(GeneralTypeService generalTypeService, ProductService productService, ProductTypeCategoryService productTypeCategoryService) {
        this.generalTypeService = generalTypeService;
        this.productService = productService;
        this.productTypeCategoryService = productTypeCategoryService;
    }

    @GetMapping("/getAll/products")
    @JsonView(ProductsViews.ShortInfo.class)
    public ResponseEntity<List<Product>> getAllProducts(@RequestBody ProductType productType) {
        return new ResponseEntity<>(productService.getAllProducts(productType), HttpStatus.OK);
    }



}

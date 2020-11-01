package ru.shop.shopapi.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.shop.dbtools.json.views.ProductsViews;
import ru.shop.dbtools.models.goods.GeneralType;
import ru.shop.dbtools.models.goods.Product;
import ru.shop.dbtools.models.goods.ProductType;
import ru.shop.shopapi.services.goods.GeneralTypeService;

import java.util.List;

@RestController
public class MainProductPageController {

    private final GeneralTypeService generalTypeService;

    public MainProductPageController(GeneralTypeService generalTypeService) {
        this.generalTypeService = generalTypeService;
    }

    @GetMapping("/getAll/general/info")
    @JsonView(ProductsViews.ShortInfo.class)
    public ResponseEntity<List<GeneralType>> getAllProducts(@RequestBody ProductType productType) {
        return new ResponseEntity<>(generalTypeService.getAllGeneralsType(),HttpStatus.OK);
    }



}

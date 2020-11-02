package ru.shop.dbtools.json.views;

import ru.shop.dbtools.models.goods.ProductTypeCategory;

public abstract class ProductsPagesViews {

    public interface NavBar extends ProductsMainViews.GeneralTypeView, ProductsTypeSingleViews.ProductsTypeWithoutProducts,  ProductsMainViews.ProductTypeCategoryView {}


}

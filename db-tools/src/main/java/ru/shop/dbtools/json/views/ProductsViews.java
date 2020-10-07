package ru.shop.dbtools.json.views;

public abstract class ProductsViews {

    public interface ShortInfo {}
    public interface SingleInfo {}
    public interface FullInfo extends ShortInfo, SingleInfo {}



}

package ru.shop.dbtools.models.goods;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import ru.shop.dbtools.json.views.ProductSingleViews;

import javax.persistence.*;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ProductSingleViews.ShortProductInfo.class)
    private Long id;
    @JsonView(ProductSingleViews.ShortProductInfo.class)
    private String name;
    @JsonView(ProductSingleViews.ShortProductInfo.class)
    private Double price;
    @JsonView(ProductSingleViews.FullSingleProductPageInfo.class)
    private String article;
    @JsonView(ProductSingleViews.FullSingleProductPageInfo.class)
    private Integer currentCount;
    @JsonView(ProductSingleViews.ShortProductInfo.class)
    private String firmProducer;
    @JsonView(ProductSingleViews.FullSingleProductPageInfo.class)
    private String description;
    @JsonView(ProductSingleViews.ShortProductInfo.class)
    private Double rating;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "productType_id")
    @JsonBackReference
    private ProductType productType;

}

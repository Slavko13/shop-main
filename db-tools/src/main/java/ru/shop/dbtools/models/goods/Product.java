package ru.shop.dbtools.models.goods;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.shop.dbtools.json.views.ProductsViews;

import javax.persistence.*;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonView(ProductsViews.ShortInfo.class)
    private String name;
    @JsonView(ProductsViews.ShortInfo.class)
    private Double price;
    @JsonView(ProductsViews.SingleInfo.class)
    private String article;
    @JsonView(ProductsViews.SingleInfo.class)
    private Integer currentCount;
    @JsonView(ProductsViews.SingleInfo.class)
    private String firmProducer;
    @JsonView(ProductsViews.SingleInfo.class)
    private String description;
    @JsonView(ProductsViews.ShortInfo.class)
    private Double rating;

    @ManyToOne
    @JsonIgnore
    @JsonView(ProductsViews.FullInfo.class)
    @JoinColumn(name="generalProductType_id")
    private GeneralProductType generalProductType;

}

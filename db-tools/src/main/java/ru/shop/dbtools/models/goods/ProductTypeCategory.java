package ru.shop.dbtools.models.goods;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.shop.dbtools.json.views.ProductTypeCategoryViews;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeCategory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ProductTypeCategoryViews.mainPageInfo.class)
    private Long id;
    @JsonView(ProductTypeCategoryViews.mainPageInfo.class)
    private String name;
    @JsonView(ProductTypeCategoryViews.fullInfo.class)
    private String description;

    @JsonView(ProductTypeCategoryViews.fullInfo.class)
    @OneToMany(mappedBy = "productTypeCategory", fetch = FetchType.LAZY)
    private List<ProductType> productsType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="generalType_id")
    private GeneralType generalType;



}

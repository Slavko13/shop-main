package ru.shop.dbtools.models.goods;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.shop.dbtools.json.views.GeneralTypeViews;
import ru.shop.dbtools.json.views.ProductTypeViews;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ProductTypeViews.shortInfo.class)
    private Long id;
    @JsonView(ProductTypeViews.shortInfo.class)
    private String name;
    @JsonView(ProductTypeViews.fullInfo.class)
    private String description;

    @JsonView(ProductTypeViews.fullInfo.class)
    @OneToMany(mappedBy = "productType", fetch = FetchType.LAZY)
    private List<Product> products;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="productTypeCategory_id")
    private ProductTypeCategory productTypeCategory;

}

package ru.shop.dbtools.models.goods;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import ru.shop.dbtools.json.views.ProductsMainViews;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "generalType")
public class ProductTypeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ProductsMainViews.ProductTypeCategoryView.class})
    private Long id;

    @JsonView({ProductsMainViews.ProductTypeCategoryView.class})
    private String name;

    @JsonView({ProductsMainViews.ProductTypeCategoryView.class})
    private String description;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "generaltype_id")
    @JsonBackReference
    @JsonView({ProductsMainViews.ProductTypeCategoryView.class})
    private GeneralType generalType;

    @OneToMany(mappedBy = "productTypeCategory", fetch = FetchType.EAGER)
    @JsonManagedReference
    @JsonView({ProductsMainViews.ProductTypeCategoryView.class})
    private List<ProductType> productType;

}

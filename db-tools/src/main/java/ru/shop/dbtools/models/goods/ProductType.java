package ru.shop.dbtools.models.goods;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import ru.shop.dbtools.json.views.ProductsTypeSingleViews;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
//@ToString(exclude = "products")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ProductsTypeSingleViews.ProductsTypeWithoutProducts.class})
    private Long id;
    @JsonView({ProductsTypeSingleViews.ProductsTypeWithoutProducts.class})
    private String name;
    @JsonView({ProductsTypeSingleViews.ProductsTypeWithoutProducts.class})
    private String description;

    @OneToMany(mappedBy = "productType", fetch = FetchType.EAGER)
    @JsonManagedReference
    @JsonView({ProductsTypeSingleViews.ProductsTypeWithProducts.class})
    private List<Product> products;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "productTypeCategory_id")
    @JsonBackReference
    private ProductTypeCategory productTypeCategory;

}

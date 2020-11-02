package ru.shop.dbtools.models.goods;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import ru.shop.dbtools.json.views.ProductsMainViews;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "productTypeCategories")
public class GeneralType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ProductsMainViews.GeneralTypeView.class})
    private Long id;
    @JsonView({ProductsMainViews.GeneralTypeView.class})
    private String name;
    @JsonView({ProductsMainViews.GeneralTypeView.class})
    private String description;

    @JsonView({ProductsMainViews.GeneralTypeView.class})
    @OneToMany(mappedBy = "generalType", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ProductTypeCategory> productTypeCategories;

}

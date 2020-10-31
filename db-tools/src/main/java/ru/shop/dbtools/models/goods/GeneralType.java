package ru.shop.dbtools.models.goods;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.shop.dbtools.json.views.GeneralTypeViews;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(GeneralTypeViews.shortInfo.class)
    private Long id;
    @JsonView(GeneralTypeViews.shortInfo.class)
    private String name;
    @JsonView(GeneralTypeViews.fullInfo.class)
    private String description;

    @OneToMany(mappedBy = "generalType", fetch = FetchType.EAGER)
    @JsonView(GeneralTypeViews.fullInfo.class)
    private List<ProductTypeCategory> productTypeCategories;

}

package ru.shop.dbtools.models.goods;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralProductType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "generalProductType", fetch = FetchType.LAZY)
    private List<Product> products;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="generalType_id")
    private GeneralType generalType;



}

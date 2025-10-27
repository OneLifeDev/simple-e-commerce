package com.onelifedev.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String name;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
//    private List<Product> products;
}

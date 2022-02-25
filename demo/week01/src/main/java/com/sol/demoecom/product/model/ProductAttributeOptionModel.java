package com.sol.demoecom.product.model;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_attribute_options")
public class ProductAttributeOptionModel extends BaseModel {
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductAttributeModel productAttribute;

    public ProductAttributeOptionModel() {
    }

    public ProductAttributeOptionModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

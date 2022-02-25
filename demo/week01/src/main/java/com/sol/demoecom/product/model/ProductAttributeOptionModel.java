package com.sol.demoecom.product.model;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_attribute_options")
public class ProductAttributeOptionModel extends BaseModel {
    private String name;

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

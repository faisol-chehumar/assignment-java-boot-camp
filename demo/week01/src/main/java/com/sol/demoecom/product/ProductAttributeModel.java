package com.sol.demoecom.product;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product_attributes")
public class ProductAttributeModel extends BaseModel {

    @OneToMany(mappedBy="productAttribute")
    private List<ProductAttributeOptionModel> productAttributeOptions;

    @OneToMany(mappedBy = "productAttribute")
    private List<ProductVariantModel> productVariants;

    private String name;

    public ProductAttributeModel() {
    }

    public ProductAttributeModel(List<ProductAttributeOptionModel> productAttributeOptions, List<ProductVariantModel> productVariants, String name) {
        this.productAttributeOptions = productAttributeOptions;
        this.productVariants = productVariants;
        this.name = name;
    }

    public List<ProductAttributeOptionModel> getProductAttributeOptions() {
        return productAttributeOptions;
    }

    public void setProductAttributeOptions(List<ProductAttributeOptionModel> productAttributeOptions) {
        this.productAttributeOptions = productAttributeOptions;
    }

    public List<ProductVariantModel> getProductVariants() {
        return productVariants;
    }

    public void setProductVariants(List<ProductVariantModel> productVariants) {
        this.productVariants = productVariants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.sol.demoecom.product.controller.mapper;

import com.sol.demoecom.common.RowMapper;
import com.sol.demoecom.product.controller.response.AttributesItem;
import com.sol.demoecom.product.controller.response.VariantsItem;
import com.sol.demoecom.product.model.ProductSkuModel;
import com.sol.demoecom.product.model.ProductVariantModel;

import java.util.ArrayList;
import java.util.List;

public class ProductVariantMapper implements RowMapper<VariantsItem, ProductSkuModel> {
    @Override
    public VariantsItem mapRow(ProductSkuModel productSkuModel) {
        return null;
    }

    @Override
    public VariantsItem mapRow(ProductSkuModel productSkuModel, List<AttributesItem> attributesItems) {
        VariantsItem variantsItem = new VariantsItem();

        variantsItem.setProductSkuId(productSkuModel.getId().toString());
        variantsItem.setSku(productSkuModel.getSku());
        variantsItem.setRegularPrice(productSkuModel.getRegularPrice());
        variantsItem.setSalePrice(productSkuModel.getSalePrice());
        variantsItem.setPercentDiscount(this.getDiscountPercent(productSkuModel.getRegularPrice(), productSkuModel.getSalePrice()));
        variantsItem.setUnitInStock(productSkuModel.getUnitInStock());
        variantsItem.setAttributeIndex(this.getAttributeIndex(productSkuModel.getProductVariants(), attributesItems));
        variantsItem.setImage(productSkuModel.getImage());

        return variantsItem;
    }

    private List<Integer> getAttributeIndex(List<ProductVariantModel> productVariant, List<AttributesItem> attributesItems) {
        List<Integer> attributeIndex = new ArrayList<>();
        attributeIndex.add(1);
        attributeIndex.add(2);
        return attributeIndex;
    }

    private int getDiscountPercent(int regularPrice, int salePrice) {
        return (100/regularPrice) * (regularPrice - salePrice);
    }
}

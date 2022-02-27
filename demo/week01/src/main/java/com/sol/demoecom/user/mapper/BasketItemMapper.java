package com.sol.demoecom.user.mapper;

import com.sol.demoecom.common.RowMapper;
import com.sol.demoecom.product.model.ProductSkuDiscountModel;
import com.sol.demoecom.product.model.ProductSkuModel;
import com.sol.demoecom.user.model.UserBasketItemModel;
import com.sol.demoecom.user.response.AttributesItem;
import com.sol.demoecom.user.response.BasketItems;

import java.util.ArrayList;
import java.util.List;

public class BasketItemMapper implements RowMapper<BasketItems, UserBasketItemModel>  {
    @Override
    public BasketItems mapRow(UserBasketItemModel userBasketItem) {
        try {
            BasketItems basketItems = new BasketItems();
            System.out.println("basketItems" + basketItems);
            ProductSkuModel productSku = userBasketItem.getProductSku();

            basketItems.setProductSkuId(productSku.getId());
            basketItems.setSku(productSku.getSku());
            basketItems.setQuantity(userBasketItem.getQuantity());
            basketItems.setRegularPrice(productSku.getRegularPrice());
            basketItems.setSalePrice(productSku.getSalePrice());
            basketItems.setPercentDiscount(this.getPercentDiscount(productSku));
            basketItems.setAttributes(this.getAttribute(productSku));
            basketItems.setAttributeIndex(this.getAttributeIndex());
            basketItems.setImage(productSku.getImage());

            return basketItems;
        } catch (Exception ex) {
            System.out.println("ex" + ex);
            return null;
        }
    }

    @Override
    public BasketItems mapRow(UserBasketItemModel userBasketItemModel, List<com.sol.demoecom.product.controller.response.AttributesItem> attributesItem) {
        return null;
    }


    private List<AttributesItem> getAttribute(ProductSkuModel productSkus) {
        List<AttributesItem> attributes = new ArrayList<>();
        attributes.add(new AttributesItem());
        return attributes;
    }

    private int getPercentDiscount(ProductSkuModel productSku) {
        int regularPrice = productSku.getRegularPrice();
        ProductSkuDiscountModel productSkuDiscount = productSku.getProductSkuDiscount();

        if(productSkuDiscount == null) {
            return 0;
        }
        int result = productSkuDiscount.getType() == ProductSkuDiscountModel.DiscountTypeEnums.PERCENT
                ? productSkuDiscount.getValue()
                : (100/regularPrice) * productSkuDiscount.getValue();
        return result;
    }

    private List<Integer> getAttributeIndex() {
        List<Integer> attributeIndex = new ArrayList<>();
        attributeIndex.add(1);
        attributeIndex.add(2);
        return attributeIndex;
    }
}

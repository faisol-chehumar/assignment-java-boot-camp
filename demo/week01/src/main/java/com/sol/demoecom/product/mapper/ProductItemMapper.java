package com.sol.demoecom.product.mapper;

import com.sol.demoecom.common.RowMapper;
import com.sol.demoecom.product.controller.response.AttributesItem;
import com.sol.demoecom.product.controller.response.ProductsItem;
import com.sol.demoecom.product.controller.response.Rating;
import com.sol.demoecom.product.model.ProductModel;
import com.sol.demoecom.product.model.ProductSkuDiscountModel;
import com.sol.demoecom.product.model.ProductSkuModel;

import java.util.*;

public class ProductItemMapper implements RowMapper<ProductsItem, ProductModel> {


    @Override
    public ProductsItem mapRow(ProductModel product) {
        try {
            ProductsItem productsItem = new ProductsItem();

            productsItem.setId(product.getId().toString());
            productsItem.setName(product.getName());
            productsItem.setImage(product.getImages().isEmpty() ? null : product.getImages().get(0).getImage());
            productsItem.setRegularPriceMin(product.getProductSkus().isEmpty() ? 0 : this.getMinMaxRegularPrice(product.getProductSkus())[1]);
            productsItem.setRegularPriceMax(product.getProductSkus().isEmpty() ? 0 : this.getMinMaxRegularPrice(product.getProductSkus())[1]);
            productsItem.setSalePriceMin(product.getProductSkus().isEmpty() ? 0 : this.getMinMaxSalePrice(product.getProductSkus())[0]);
            productsItem.setSalePriceMax(product.getProductSkus().isEmpty() ? 0 : this.getMinMaxSalePrice(product.getProductSkus())[1]);
            productsItem.setPercentDiscountMin(product.getProductSkus().isEmpty() ? 0 : this.getMinMaxPercentDiscount(product.getProductSkus())[0]);
            productsItem.setPercentDiscountMax(product.getProductSkus().isEmpty() ? 0 : this.getMinMaxPercentDiscount(product.getProductSkus())[1]);
            productsItem.setShopLocation(product.getShopLocation());
            productsItem.setRatingStar(this.getRating().getRatingStar());

            return productsItem;
        } catch (Exception ex) {
            System.out.println("ex" + ex);
            return null;
        }
    }

    @Override
    public ProductsItem mapRow(ProductModel productModel, List<AttributesItem> attributesItem) {
        return null;
    }

    private Rating getRating() {
        Integer ratingCount = 1324;
        double ratingStar = 4.8;

        Rating ratingResult = new Rating();
        ratingResult.setRatingCount(ratingCount);
        ratingResult.setRatingStar(ratingStar);

        return ratingResult;
    }

    private int[] getMinMaxRegularPrice(List<ProductSkuModel> productSkus) {
        if(productSkus.size() == 1) {
            return new int[]{productSkus.get(0).getRegularPrice(), productSkus.get(0).getRegularPrice()};
        }
        IntSummaryStatistics summaryStatistics = productSkus.stream()
                .mapToInt(ProductSkuModel::getRegularPrice)
                .summaryStatistics();

        int minPrice = summaryStatistics.getMin();
        int maxPrice = summaryStatistics.getMax();
        int[] result = new int[]{minPrice, maxPrice};

        return result;
    }

    private int[] getMinMaxSalePrice(List<ProductSkuModel> productSkus) {
        if(productSkus.size() == 1) {
            return new int[]{productSkus.get(0).getSalePrice(), productSkus.get(0).getSalePrice()};
        }
        IntSummaryStatistics summaryStatistics = productSkus.stream()
                .map(productSku -> productSku.getRegularPrice() - productSku.getSalePrice())
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        int minPrice = summaryStatistics.getMin();
        int maxPrice = summaryStatistics.getMax();
        int[] result = new int[]{minPrice, maxPrice};

        return result;
    }

    private int[] getMinMaxPercentDiscount(List<ProductSkuModel> productSkus) {
        if(productSkus.size() == 1) {
            return new int[]{this.getDiscountValue(productSkus.get(0).getRegularPrice(), productSkus.get(0).getProductSkuDiscount()), this.getDiscountValue(productSkus.get(0).getRegularPrice(), productSkus.get(0).getProductSkuDiscount())};
        }
        IntSummaryStatistics summaryStatistics = productSkus.stream()
                .map(productSku -> this.getDiscountValue(productSku.getRegularPrice(), productSku.getProductSkuDiscount()))
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        int minDiscount = summaryStatistics.getMin();
        int maxDiscount = summaryStatistics.getMax();
        int[] result = new int[]{minDiscount, maxDiscount};

        return result;
    }

    private int getDiscountValue(int regularPrice, ProductSkuDiscountModel productSkuDiscount) {
        if(productSkuDiscount == null) {
            return 0;
        }
        int result = productSkuDiscount.getType() == ProductSkuDiscountModel.DiscountTypeEnums.PERCENT
                ? productSkuDiscount.getValue()
                : (100/regularPrice) * productSkuDiscount.getValue();
        return result;
    }
}

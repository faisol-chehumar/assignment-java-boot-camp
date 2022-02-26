package com.sol.demoecom.product.mapper;

import com.sol.demoecom.product.controller.response.*;
import com.sol.demoecom.product.model.ProductAttributeModel;
import com.sol.demoecom.product.model.ProductModel;
import com.sol.demoecom.product.model.ProductSkuDiscountModel;
import com.sol.demoecom.product.model.ProductSkuModel;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDetailMapper implements RowMapper<ProductDetail, ProductModel> {
    @Override
    public ProductDetail mapRow(ProductModel product) {
        ProductDetail productDetail = new ProductDetail();

        productDetail.setId(product.getId().toString());
        productDetail.setName(product.getName());
        productDetail.setDescription(product.getDescription());
        productDetail.setProductNumber(product.getProductNumber());
        productDetail.setImages(product.getImages().stream().map(p -> p.getImage()).collect(Collectors.toList()));
        productDetail.setRegularPriceMin(product.getProductSkus().isEmpty() ? 0 : this.getRegularPrice(product.getProductSkus())[1]);
        productDetail.setRegularPriceMax(product.getProductSkus().isEmpty() ? 0 : this.getRegularPrice(product.getProductSkus())[1]);
        productDetail.setSalePriceMin(product.getProductSkus().isEmpty() ? 0 : this.getSalePrice(product.getProductSkus())[0]);
        productDetail.setSalePriceMax(product.getProductSkus().isEmpty() ? 0 : this.getSalePrice(product.getProductSkus())[1]);
        productDetail.setPercentDiscountMin(product.getProductSkus().isEmpty() ? 0 : this.getPercentDiscount(product.getProductSkus())[0]);
        productDetail.setPercentDiscountMax(product.getProductSkus().isEmpty() ? 0 : this.getPercentDiscount(product.getProductSkus())[1]);
        productDetail.setWarrantyDays(product.getWarrantDays());
        productDetail.setRating(this.getRating());
        List<AttributesItem> attributesItems = this.getAttribute(product.getProductSkus());

        productDetail.setVariants(product.getProductSkus().stream().map(p -> new ProductVariantMapper().mapRow(p, attributesItems)).collect(Collectors.toList()));

        return productDetail;
    }

    @Override
    public ProductDetail mapRow(ProductModel productModel, List<AttributesItem> attributesItem) {
        return null;
    }

    private List<AttributesItem> getAttribute(List<ProductSkuModel> productSkus) {
        List<AttributesItem> attributes = new ArrayList<>();
        attributes.add(new AttributesItem());
        return attributes;
    }

    private int[] getRegularPrice(List<ProductSkuModel> productSkus) {
        IntSummaryStatistics summaryStatistics = productSkus.stream()
                .mapToInt(ProductSkuModel::getRegularPrice)
                .summaryStatistics();

        int[] result = new int[]{};
        int minPrice = summaryStatistics.getMin();
        int maxPrice = summaryStatistics.getMax();

        result[0] = minPrice;
        result[1] = maxPrice;

        return result;
    }

    private int[] getSalePrice(List<ProductSkuModel> productSkus) {
        IntSummaryStatistics summaryStatistics = productSkus.stream()
                .map(productSku -> productSku.getRegularPrice() - productSku.getProductSkuDiscount().getValue())
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        int[] result = new int[]{};
        int minPrice = summaryStatistics.getMin();
        int maxPrice = summaryStatistics.getMax();

        result[0] = minPrice;
        result[1] = maxPrice;

        return result;
    }


    private int[] getPercentDiscount(List<ProductSkuModel> productSkus) {
        IntSummaryStatistics summaryStatistics = productSkus.stream()
                .map(ProductSkuModel::getProductSkuDiscount)
                .mapToInt(ProductSkuDiscountModel::getValue)
                .summaryStatistics();

        int[] result = new int[]{};
        int minDiscount = summaryStatistics.getMin();
        int maxDiscount = summaryStatistics.getMax();

        result[0] = minDiscount;
        result[1] = maxDiscount;

        return result;
    }

    private Rating getRating() {
        Integer ratingCount = 1324;
        double ratingStar = 4.8;

        Rating ratingResult = new Rating();
        ratingResult.setRatingCount(ratingCount);
        ratingResult.setRatingStar(ratingStar);

        return ratingResult;
    }
}

package com.sol.demoecom.product.controller.mapper;

import com.sol.demoecom.common.RowMapper;
import com.sol.demoecom.product.controller.response.*;
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
        productDetail.setRegularPriceMin(product.getProductSkus().isEmpty() ? 0 : this.getMinMaxRegularPrice(product.getProductSkus())[1]);
        productDetail.setRegularPriceMax(product.getProductSkus().isEmpty() ? 0 : this.getMinMaxRegularPrice(product.getProductSkus())[1]);
        productDetail.setSalePriceMin(product.getProductSkus().isEmpty() ? 0 : this.getMinMaxSalePrice(product.getProductSkus())[0]);
        productDetail.setSalePriceMax(product.getProductSkus().isEmpty() ? 0 : this.getMinMaxSalePrice(product.getProductSkus())[1]);
        productDetail.setPercentDiscountMin(product.getProductSkus().isEmpty() ? 0 : this.getMinMaxPercentDiscount(product.getProductSkus())[0]);
        productDetail.setPercentDiscountMax(product.getProductSkus().isEmpty() ? 0 : this.getMinMaxPercentDiscount(product.getProductSkus())[1]);
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

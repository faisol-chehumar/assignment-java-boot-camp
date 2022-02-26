package com.sol.demoecom.product.mapper;

import com.sol.demoecom.product.controller.response.ProductsItem;
import com.sol.demoecom.product.controller.response.Rating;
import com.sol.demoecom.product.model.ProductModel;
import com.sol.demoecom.product.model.ProductSkuDiscountModel;
import com.sol.demoecom.product.model.ProductSkuModel;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.*;

public class ProductItemMapper implements RowMapper<ProductsItem, ProductModel> {
    @Override
    public ProductsItem mapRow(ProductModel product) {
        try {
            ProductsItem productsItem = new ProductsItem();

            productsItem.setId(product.getId().toString());
            productsItem.setName(product.getName());
            productsItem.setImage(product.getImages().isEmpty() ? null : product.getImages().get(0).getImage());
            productsItem.setRegularPriceMin(product.getProductSkus().isEmpty() ? 0 : this.getRegularPrice(product.getProductSkus())[1]);
            productsItem.setRegularPriceMax(product.getProductSkus().isEmpty() ? 0 : this.getRegularPrice(product.getProductSkus())[1]);
            productsItem.setSalePriceMin(product.getProductSkus().isEmpty() ? 0 : this.getSalePrice(product.getProductSkus())[0]);
            productsItem.setSalePriceMax(product.getProductSkus().isEmpty() ? 0 : this.getSalePrice(product.getProductSkus())[1]);
            productsItem.setPercentDiscountMin(product.getProductSkus().isEmpty() ? 0 : this.getPercentDiscount(product.getProductSkus())[0]);
            productsItem.setPercentDiscountMax(product.getProductSkus().isEmpty() ? 0 : this.getPercentDiscount(product.getProductSkus())[1]);
            productsItem.setShopLocation(product.getShopLocation());
            productsItem.setRatingStar(this.getRating().getRatingStar());

            return productsItem;
        } catch (Exception ex) {
            System.out.println("ex" + ex);
            return null;
        }
    }

    private Rating getRating() {
        List<Integer> ratingCount = Arrays.asList(0, 0, 0, 0, 0);
        double ratingStar = 4.8;

        Rating ratingResult = new Rating();
        ratingResult.setRatingCount(ratingCount);
        ratingResult.setRatingStar(ratingStar);

        return ratingResult;
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
}

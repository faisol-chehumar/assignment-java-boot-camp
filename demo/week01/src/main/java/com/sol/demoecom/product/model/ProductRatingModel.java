package com.sol.demoecom.product.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_ratings")
public class ProductRatingModel extends BaseModel {
    public enum RatingEnums {
        ONE, TWO, THREE, FOUR, FIVE;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private ProductSkuModel productSku;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private OrderModel order;

    private RatingEnums rating;

    public ProductRatingModel() {
    }

    public ProductRatingModel(RatingEnums rating) {
        this.rating = rating;
    }

    public RatingEnums getRating() {
        return rating;
    }

    public void setRating(RatingEnums rating) {
        this.rating = rating;
    }
}

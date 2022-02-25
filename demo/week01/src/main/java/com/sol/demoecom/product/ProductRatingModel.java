package com.sol.demoecom.product;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "product_ratings")
public class ProductRatingModel extends BaseModel {
    public enum RatingEnums {
        ONE, TWO, THREE, FOUR, FIVE;
    }

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

package com.sol.demoecom.product.repository;

import com.sol.demoecom.product.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
    List<ProductModel> findByNameContainsIgnoreCase(String name);
    long count();
}

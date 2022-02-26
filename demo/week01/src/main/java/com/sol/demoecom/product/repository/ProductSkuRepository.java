package com.sol.demoecom.product.repository;

import com.sol.demoecom.product.model.ProductSkuModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductSkuRepository extends JpaRepository<ProductSkuModel, UUID> {
}

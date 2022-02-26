package com.sol.demoecom.user.repository;

import com.sol.demoecom.user.model.UserBasketModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserBasketRepository extends JpaRepository<UserBasketModel, UUID> {
}

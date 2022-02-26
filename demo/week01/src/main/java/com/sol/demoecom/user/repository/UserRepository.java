package com.sol.demoecom.user.repository;

import com.sol.demoecom.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    Optional<UserModel> findByUsernameAndPassword(String name, String password);
}


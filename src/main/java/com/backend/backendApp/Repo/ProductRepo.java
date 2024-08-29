package com.backend.backendApp.Repo;

import com.backend.backendApp.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product , String> {
  Optional<Product> findById(String id);

}

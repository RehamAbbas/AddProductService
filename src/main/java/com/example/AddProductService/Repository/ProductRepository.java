package com.example.AddProductService.Repository;


import com.example.AddProductService.Model.Product; // Repository will manage Product Entity
import org.springframework.data.jpa.repository.JpaRepository; // A Spring Data JPA interface that provides built-in methods for database operations.
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // No need to implement this interface manually.
    // Spring Data JPA automatically provides the implementation at runtime.
}

package com.anish.golu.repositories.product;

import com.anish.golu.models.product.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Long> {
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long Long);

    List<Product> findByCategory(String name);

    @Override
    void deleteById(Long id);
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.title = :title, p.price = :price, p.category = :category, p.description = :description, p.imageUrl = :imageUrl WHERE p.id = :id")
    void replaceProductFields(@Param("id") Long id, @Param("title") String title, @Param("price") double price, @Param("category") String category, @Param("description") String description, @Param("imageUrl") String imageUrl);

}

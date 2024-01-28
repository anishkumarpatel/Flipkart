package com.anish.golu.services;

import com.anish.golu.models.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {
    Product getSingleProduct(Long id);

    List<Product> getAllProducts();

    Product addNewProduct(Product product);

    void deleteProduct(Long id);

    List<Product> getAllCategories(String name);

    Product updateProduct(Long id, Product product);

    void replaceProduct(Long id,Product product);

    void populateFakeStore();
}

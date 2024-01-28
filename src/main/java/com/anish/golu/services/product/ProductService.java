package com.anish.golu.services.product;

import com.anish.golu.models.product.Product;

import java.util.List;

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

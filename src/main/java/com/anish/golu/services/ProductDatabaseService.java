package com.anish.golu.services;

import com.anish.golu.models.Product;
import com.anish.golu.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDatabaseService implements ProductService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    @Autowired // Autowire, it is optional
    public ProductDatabaseService(ProductRepository productRepository, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.productRepository = productRepository;
    }

    @Override
    public void populateFakeStore() {
        // Resttemplate call the product api
        // loop over all the prodcuts and call productRepsository.save();
         // RestTemplate restTemplate = new RestTemplate();// if we are not configuring then we can
        Product[] response = restTemplate.getForObject("https://fakestoreapi.com/products", Product[].class);

        for (Product p : response) {
            //  Product p = convertFakeToProduct(fake);
            if (p.getDescription() != null) p.setDescription(p.getDescription().substring(0, 4));
            productRepository.save(p);
        }
    }


    @Override
    public Product getSingleProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) throw new RuntimeException("This exception raised , please valid id");
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public Product addNewProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllCategories(String name) {
        return productRepository.findByCategory(name);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        // Step 1: Retrieve the existing product from the database
        Optional<Product> existingProductOptional = productRepository.findById(id);

        if (existingProductOptional.isPresent()) {
            // Step 2: Update properties with values from the provided product
            Product existingProduct = existingProductOptional.get();
            existingProduct.setTitle(product.getTitle());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setImageUrl(product.getImageUrl());

            // Step 3: Save the updated product back to the database
            Product updatedProduct = productRepository.save(existingProduct);

            // Step 4: Return the updated product
            return updatedProduct;
        } else {
            // Handle the case where the product with the given id is not found
            throw new RuntimeException("Product with id " + id + " not found");
        }
    }

    public void replaceProduct(Long id, Product newProduct) {
        // Step 1: Retrieve the existing product from the database
        Optional<Product> existingProductOptional = productRepository.findById(id);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            // Step 2: Update the existing product with the non-null fields of the new product
            if (newProduct.getTitle() != null) {
                existingProduct.setTitle(newProduct.getTitle());
            }

            if (newProduct.getPrice() != 0.0) {
                existingProduct.setPrice(newProduct.getPrice());
            }

            if (newProduct.getDescription() != null) {
                existingProduct.setDescription(newProduct.getDescription());
            }
            if (newProduct.getCategory() != null) {
                existingProduct.setCategory(newProduct.getCategory());
            }
            if (newProduct.getImageUrl() != null) {
                existingProduct.setImageUrl(newProduct.getImageUrl());
            }

            // Add other fields as needed

            // Step 3: Save the updated product
            productRepository.replaceProductFields(existingProduct.getId(), existingProduct.getTitle(), existingProduct.getPrice(), existingProduct.getCategory(), existingProduct.getDescription(), existingProduct.getImageUrl());
        }
    }
}

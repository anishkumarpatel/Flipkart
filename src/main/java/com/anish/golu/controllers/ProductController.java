package com.anish.golu.controllers;

import com.anish.golu.models.Product;
import com.anish.golu.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    //@Autowired this is optional
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addproduct")
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return  productService.getSingleProduct(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/categories/{name}")
    public List<Product> getAllCategories(@PathVariable("name") String name){
        return productService.getAllCategories(name);
    }

    @DeleteMapping("/{id}")
    public  void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.updateProduct(id,product) ;
    }

    @PatchMapping("/{id}")
    public void replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){
        productService.replaceProduct(id,product) ;
    }

    @PostMapping("/populate")
    public void populateFakeStore(){
        productService.populateFakeStore();
    }

}

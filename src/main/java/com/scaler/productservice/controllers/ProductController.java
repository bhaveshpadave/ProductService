package com.scaler.productservice.controllers;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    public ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable ("id") Long id) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.OK);
    };

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

//    public Product addNewProduct() {
//
//    }

    public void deleteProduct(Long id) { }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable ("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable ("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

}

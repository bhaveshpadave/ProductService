package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product updateProduct(Long productId, Product product) throws ProductNotFoundException;

    Product replaceProduct(Long productId, Product product) throws ProductNotFoundException;

    void deleteProduct(Long productId);

    Product addProduct(Product product);
}

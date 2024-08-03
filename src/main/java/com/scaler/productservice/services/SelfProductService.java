package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {

        Optional<Product> productOptional = productRepository.findById(productId);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException(productOptional + " not found");
        }

        return productOptional.get();
    }

    //GET
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //PATCH (Partial update)
    @Override
    public Product updateProduct(Long productId, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(productId);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id: " + productId + " doesn't exist");
        }

        Product productInDB = productOptional.get();

        if(product.getTitle() != null){
            productInDB.setTitle(product.getTitle());
            product = productInDB;
        }

        return productRepository.save(product);
    }

    //PUT ()
    @Override
    public Product replaceProduct(Long productId, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(productId) ;

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id: " + productId + " doesn't exist");
        }

        Product productInDB = productOptional.get();

        if(product.getTitle() != null){
            productInDB.setTitle(product.getTitle());
        }
        if(product.getDescription() != null){
            productInDB.setDescription(product.getDescription());
        }
        if(product.getQuantity() != 0){
            productInDB.setQuantity(product.getQuantity());
        }
        if(product.getPrice() != 0){
            productInDB.setPrice(product.getPrice());
        }

        productInDB.setUpdatedAt(new java.util.Date());

        product = productInDB;

        return productRepository.save(product);
    }

    //DELETE
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    //POST
    @Override
    public Product addProduct(Product product) {
        Category category = product.getCategory();

        if(category.getId() == null){
            // Creating new category
            category = categoryRepository.save(category);

            //Setting it to new product
            product.setCategory(category);
        }
        return productRepository.save(product);
    }
}

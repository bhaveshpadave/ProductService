package com.scaler.productservice;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.projections.ProductWithIdAndTitle;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testDBQueries() {
        ProductWithIdAndTitle productWithIdAndTitles = productRepository.randomSearchMethod2(13L);

//        Optional<Product> product = productRepository.findById(1L);

//        Optional<Category> optionalCategory = categoryRepository.findById(1L);

//        Category category = optionalCategory.get();

//        System.out.println("Getting Products");

//        List<Product> products = category.getProducts();

        System.out.println("DEBUG");
    }

}

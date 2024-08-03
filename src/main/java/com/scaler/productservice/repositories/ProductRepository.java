package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Declared queries

    List<Product> findAllBy();
    Optional<Product> findProductByTitle(String title);
    Optional<Product> findProductByCategory(Category category);
    Optional<Product> findById(Long productId);
    Product save(Product product);

    //HQL
    @Query("select p.id as id, p.title as title from Product p where id = :l")
    ProductWithIdAndTitle randomSearchMethod(long l);

    //SQL
    @Query(value = "select p.id as id, p.title as title from Product p where id = :l", nativeQuery = true)
    ProductWithIdAndTitle randomSearchMethod2(long l);
}
/**
 * Repository should be an Interface which extends JpaRepository class
 * Read, Delete, Create, Update
 */
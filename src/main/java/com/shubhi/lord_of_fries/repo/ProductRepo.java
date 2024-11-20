package com.shubhi.lord_of_fries.repo;

import com.shubhi.lord_of_fries.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice ORDER BY p.price ASC")
    List<Product> findTop2(@Param("minPrice") double minPrice,
                           @Param("maxPrice") double maxPrice);

}

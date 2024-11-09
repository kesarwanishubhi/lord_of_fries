package com.shubhi.lord_of_fries.repo;

import com.shubhi.lord_of_fries.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.price > :price")
    List<Product> findByPriceGreaterThan(@Param("price") double price);

}

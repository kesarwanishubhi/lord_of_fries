package com.shubhi.lord_of_fries.controller;

import com.shubhi.lord_of_fries.entity.Product;
import com.shubhi.lord_of_fries.repo.ProductRepo;
import com.shubhi.lord_of_fries.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductRepo productRepository;

    public ProductController(ProductService productService, ProductRepo productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/allproducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/top2")
    public List<Product> getTop2(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return productService.getTop2(minPrice, maxPrice);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product updatedProduct
    ) {
        return productService.updateProduct(id, updatedProduct)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productService.deleteProduct(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.shubhi.lord_of_fries.service;

import com.shubhi.lord_of_fries.entity.Product;
import com.shubhi.lord_of_fries.repo.ProductRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepo productRepository;

    public ProductService(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getTop2(double minPrice, double maxPrice) {
        return productRepository.findTop2(minPrice, maxPrice);
    }

    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setPrice(updatedProduct.getPrice());
                    return productRepository.save(existingProduct);
                });
    }

    public boolean deleteProduct(Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return true;
                })
                .orElse(false);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
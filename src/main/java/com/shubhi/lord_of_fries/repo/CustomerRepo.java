package com.shubhi.lord_of_fries.repo;

import com.shubhi.lord_of_fries.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerRepo extends JpaRepository<Customer, Long> {
    public Customer findByEmail(String email);
}

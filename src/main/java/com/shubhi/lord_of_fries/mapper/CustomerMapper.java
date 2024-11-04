package com.shubhi.lord_of_fries.mapper;

import com.shubhi.lord_of_fries.dto.CustomerRequest;
import com.shubhi.lord_of_fries.entity.Customer;
import org.springframework.stereotype.Component;

import java.sql.ConnectionBuilder;
@Component
public class CustomerMapper {
    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}

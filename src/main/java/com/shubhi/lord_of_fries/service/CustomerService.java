package com.shubhi.lord_of_fries.service;

import com.shubhi.lord_of_fries.dto.CustomerRequest;
import com.shubhi.lord_of_fries.entity.Customer;
import com.shubhi.lord_of_fries.mapper.CustomerMapper;
import com.shubhi.lord_of_fries.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepo rep;
    private final CustomerMapper mapper;

    public String creating(CustomerRequest request) {

        Customer customer = mapper.toEntity(request);
        rep.save(customer);
        return "created";

    }




}

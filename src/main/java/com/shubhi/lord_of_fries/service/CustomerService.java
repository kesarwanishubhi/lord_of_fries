package com.shubhi.lord_of_fries.service;

import com.shubhi.lord_of_fries.dto.CustomerRequest;
import com.shubhi.lord_of_fries.dto.LoginRequest;
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
    public String loginchecking(LoginRequest  req){
        Customer customer=rep.findByEmail(req.email());
        if(customer==null){ return "Invalid email";}
        else{
            if(customer.getPassword().equals(req.password())){return "Login Successfull";}
            else return "Invalid password";
        }
    }




}

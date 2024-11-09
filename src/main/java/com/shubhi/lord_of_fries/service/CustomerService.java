package com.shubhi.lord_of_fries.service;

import com.shubhi.lord_of_fries.dto.CustomerRequest;
import com.shubhi.lord_of_fries.dto.CustomerResponse;
import com.shubhi.lord_of_fries.dto.LoginRequest;
import com.shubhi.lord_of_fries.entity.Customer;
import com.shubhi.lord_of_fries.exception.CustomerNotFound;
import com.shubhi.lord_of_fries.hepler.EncryptionService;
import com.shubhi.lord_of_fries.hepler.JwtHelper;
import com.shubhi.lord_of_fries.mapper.CustomerMapper;
import com.shubhi.lord_of_fries.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepo rep;
    private final CustomerMapper mapper;
    private  final EncryptionService encryptionService;
    private final JwtHelper jwtHelper;

    public String creating(CustomerRequest request) {

        Customer customer = mapper.toEntity(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));

        rep.save(customer);
        return "created";

    }

    public Customer getCustomer(String email) {
        return rep.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFound(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
    }

    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return mapper.toResponse(customer);
    }

    public String loginchecking(LoginRequest  req){
        Customer customer=rep.findByEmail(req.email()).orElseThrow(() -> new CustomerNotFound("Not found"));
        if(encryptionService.validates(req.password(),customer.getPassword())){
            return jwtHelper.generateToken(req.email());
        }
        return "failed";


    }




}

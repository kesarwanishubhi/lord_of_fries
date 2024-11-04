package com.shubhi.lord_of_fries.controller;

import com.shubhi.lord_of_fries.dto.CustomerRequest;
import com.shubhi.lord_of_fries.dto.LoginRequest;
import com.shubhi.lord_of_fries.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
   public ResponseEntity<?> createCustomer(@RequestBody @Valid CustomerRequest req){
        return ResponseEntity.ok(customerService.creating(req));
   }
   @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest req){
       return ResponseEntity.ok(customerService.loginchecking(req));

   }

}

package com.shubhi.lord_of_fries.controller;

import com.shubhi.lord_of_fries.dto.CustomerRequest;
import com.shubhi.lord_of_fries.dto.LoginRequest;
import com.shubhi.lord_of_fries.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
   public ResponseEntity<?> createCustomer(@RequestBody @Valid CustomerRequest req){
        return ResponseEntity.ok(customerService.creating(req));
   }
   @GetMapping("/email")
   public ResponseEntity<?> getCustomer(@PathVariable("/email") String email){
        return ResponseEntity.ok(customerService.retrieveCustomer((email)));
    }
   @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest req){
       return ResponseEntity.ok(customerService.loginchecking(req));

   }

}

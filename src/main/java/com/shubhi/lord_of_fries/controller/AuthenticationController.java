package com.shubhi.lord_of_fries.controller;

import com.shubhi.lord_of_fries.dto.LoginRequest;
import com.shubhi.lord_of_fries.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/auth")

@RequiredArgsConstructor

public class AuthenticationController {
    private final CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(customerService.loginchecking(request));
    }
}

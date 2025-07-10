package com.example.JwtSecurityToken.controller;

import com.example.JwtSecurityToken.dto.LoginRequest;
import com.example.JwtSecurityToken.dto.RefreshTokenRequest;
import com.example.JwtSecurityToken.dto.RegisterRequest;
import com.example.JwtSecurityToken.dto.TokenPair;
import com.example.JwtSecurityToken.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest request){

        authService.registerUser(request);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){
        TokenPair tokenPair = authService.login(loginRequest);
        return ResponseEntity.ok(tokenPair);

    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@Valid @RequestBody RefreshTokenRequest request){
        TokenPair tokenPair=authService.refreshToken(request);
        return ResponseEntity.ok(tokenPair);
    }

}

package com.example.JwtSecurityToken.dto;

import com.example.JwtSecurityToken.model.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Full name is required")
    @Size(min=3,max=50,message = "Fullname must be between 3 and 50 characters")
    private String fullname;

    @NotBlank(message = "Username is required")
    @Size(min=3,max=10,message = "Username must be between 3 and 10 characters")
    private String username;


    @NotBlank(message = "Password is required")
    @Size(min=3,message = "Password must be at least 3 characters")
    private String password;


    private Role role;
}

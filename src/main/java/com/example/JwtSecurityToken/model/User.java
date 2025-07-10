package com.example.JwtSecurityToken.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="application_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column(
            name = "full_name",
            nullable = false
    )
    private String fullname;

   @Column(
            nullable = false,
            unique = true
    )
    private String username;


   @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String fullname, String username, String password, Role role) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

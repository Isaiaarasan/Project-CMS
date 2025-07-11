package com.example.springbootfirst.models;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {
    private int empId;
    private String name;
    private String email;
    private String password;
    private String userName;
    private Set<String> roleNames;
}

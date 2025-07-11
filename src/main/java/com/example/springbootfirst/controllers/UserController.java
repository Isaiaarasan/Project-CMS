package com.example.springbootfirst.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegisterDetailsRepository repository;

    @GetMapping
    public List<RegisterDetails> getAllUsers() {
        return repository.findAll();
    }
}
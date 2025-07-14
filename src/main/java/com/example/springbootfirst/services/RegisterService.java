package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
   @Autowired
    RegisterRepository registerRepo;
   public String createEmployee(RegisterDetails registerDetails){
       registerRepo.save(registerDetails);
       return "Register Sucessfully";
   }
}

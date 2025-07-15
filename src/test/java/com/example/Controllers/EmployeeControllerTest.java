package com.example.Controllers;

import com.example.springbootfirst.controllers.EmployeeController;
import com.example.springbootfirst.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @Mock
    EmployeeController employeeController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
}


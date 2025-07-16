package com.example.Controllers;

import com.example.deploy.models.RegisterDetails;
import com.example.deploy.models.UserDetailsDto;
import com.example.deploy.services.EmployeeService;

import com.example.springbootfirst.controllers.EmployeeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRoute(){
        String result = employeeController.route();
        assertEquals("Welcome to SpringBoot Security", result);
        System.out.println("23EC184 - testRoute passed");
    }

    @Test
    void testgetMethod(){
        RegisterDetails emp1 = new RegisterDetails();
        emp1.setName("vishwaridha");
        emp1.setEmail("vishwa@gmail.com");

        RegisterDetails emp2 = new RegisterDetails();
        emp2.setName("vishwaridha");
        emp2.setEmail("vishwa@gmail.com");

        when(employeeService.getMethod()).thenReturn(Arrays.asList(emp1, emp2));
        List<RegisterDetails> result = employeeController.getMethod();
        assertEquals(2, result.size());
        assertEquals("vishwaridha", result.get(0).getName());
        assertEquals("vishwa@gmail.com", result.get(0).getEmail());

        System.out.println("23EC184 - testgetMethod passed");
    }

    @Test
    void testgetEmployeeById(){
        int empid = 1;
        RegisterDetails emp1 = new RegisterDetails();
        emp1.setEmpID(empid);
        emp1.setName("vishwaridha");
        emp1.setEmail("vishwa@gmail.com");

        when(employeeService.getEmployeeById(empid)).thenReturn(emp1);
        RegisterDetails result = employeeController.getEmployeeById(empid);
        assertEquals(empid, result.getEmpID());
        assertEquals("vishwaridha", result.getName());
        assertEquals("vishwa@gmail.com", result.getEmail());

        System.out.println("23EC184 - testgetEmployeeById passed");
    }

    @Test
    void testaddnewEmployee(){
        UserDetailsDto user = new UserDetailsDto();
        user.setName("vishwaridha");
        user.setEmail("vishwa@gmail.com");
        user.setPassword("vish3007#");

        String expectedMessage = "Employee added successfully";
        when(employeeService.addNewEmployee(user)).thenReturn(expectedMessage);
        String result = employeeController.addnewEmployee(user);
        assertEquals(expectedMessage, result);

        System.out.println("23EC184 - testaddnewEmployee passed");
    }

    @Test
    void testupdateEmployee(){
        int empId = 1;
        UserDetailsDto user = new UserDetailsDto();
        user.setName("vishwaridha");
        user.setEmail("vishwa@gmail.com");

        String expectedMessage = "Employee updated successfully";
        when(employeeService.updateEmployee(empId, user)).thenReturn(expectedMessage);
        String result = employeeController.updateEmployee(empId, user);
        assertEquals(expectedMessage, result);

        System.out.println("23EC184 - testupdateEmployee passed");


    }
}
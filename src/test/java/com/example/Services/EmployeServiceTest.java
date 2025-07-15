package com.example.Services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import com.example.springbootfirst.services.EmployeeService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeServiceTest {

    @Mock
    RegisterDetailsRepository registerDetailsRepository;

    @InjectMocks
    EmployeeService employeeService;
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    void testGetMethod(){
        RegisterDetails emp1=new RegisterDetails();
        RegisterDetails emp2= new RegisterDetails();
        when(registerDetailsRepository.findAll()).thenReturn(Arrays.asList(emp1,emp2));
        List<RegisterDetails> result = employeeService.getMethod();
        assertEquals(2,result.size());
    }
}

package com.springbootweb.springboot.web.controllers;

import com.springbootweb.springboot.web.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @GetMapping("/employees/{employeeId}")
    public EmployeeDto getEmployeeById(@PathVariable Long employeeId){
        return new EmployeeDto(employeeId, LocalDate.of(2023,12,1),true,"Sayan Chatterjee");
    }
    @GetMapping("/employees/get2")
    public String employeeBySort(@RequestParam(required = false) Integer age,
                                 @RequestParam(required = false,defaultValue = "Chandrika") String name ){
        return "Hi"+" "+ age + " "+ name;
    }
    @PostMapping("/post")
    public String getPost(){
        return "Hello from post";
    }
    @PostMapping("/postEmployee")
    public EmployeeDto employeeDtopost(@RequestBody EmployeeDto employee1){
        employee1.setId(100l);
        employee1.setActive(false);
        return employee1;
    }
    @PutMapping("/put")
    public String getPut(){
        return "Hello from put";
    }

}

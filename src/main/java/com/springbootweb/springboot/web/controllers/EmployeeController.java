package com.springbootweb.springboot.web.controllers;

import com.springbootweb.springboot.web.dto.EmployeeDto;
import com.springbootweb.springboot.web.entities.EmployeeEntity;
import com.springbootweb.springboot.web.repositories.Employeerepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private final Employeerepository employeerepository;

    public EmployeeController(Employeerepository employeerepository) {
        this.employeerepository = employeerepository;
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId){
        return employeerepository.findById(employeeId).orElse(null);
    }
    @GetMapping("/employees/get2")
    public String employeeBySort(@RequestParam(required = false) Integer age,
                                 @RequestParam(required = false,defaultValue = "Chandrika") String name ){
        return "Hi"+" "+ age + " "+ name;
    }
    @GetMapping("/getAllEmployees")
    public List<EmployeeEntity> getAllEmployees(){
        return employeerepository.findAll();
    }
    @PostMapping("/post")
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity newEmployee){
        return employeerepository.save(newEmployee);
    }
//    @PostMapping("/postEmployee")
//    public EmployeeDto employeeDtopost(@RequestBody EmployeeDto employee1){
//        employee1.setId(100l);
//        employee1.setActive(false);
//        return employee1;
//    }
    @PutMapping("/put")
    public String getPut(){
        return "Hello from put";
    }

}

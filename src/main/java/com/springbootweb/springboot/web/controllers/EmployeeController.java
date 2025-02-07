package com.springbootweb.springboot.web.controllers;
import com.springbootweb.springboot.web.dto.EmployeeDto;
import com.springbootweb.springboot.web.services.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{EmployeeId}")
    public EmployeeDto getEmployeeById(@PathVariable Long EmployeeId) {
        return employeeService.getEmployeeById(EmployeeId);
    }
    @PostMapping("/postEmployee")
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.saveEmployee(employeeDto);
    }
    @GetMapping("/getAllEmployees")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}



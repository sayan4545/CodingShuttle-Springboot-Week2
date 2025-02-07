package com.springbootweb.springboot.web.controllers;
import com.springbootweb.springboot.web.dto.EmployeeDto;
import com.springbootweb.springboot.web.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{EmployeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long EmployeeId) {
        //return employeeService.getEmployeeById(EmployeeId);
        EmployeeDto employee = employeeService.getEmployeeById(EmployeeId);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(employee);
        }
    }
    @PostMapping("/postEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        //return employeeService.saveEmployee(employeeDto);
        EmployeeDto newEmployee = employeeService.saveEmployee(employeeDto);
        return new  ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }
    @GetMapping("/getAllEmployees")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @PutMapping("/updateEmployee/{employeeId}")
    public EmployeeDto updateEmployeeById(@RequestBody EmployeeDto employeeDto,@PathVariable Long EmployeeId){
        return employeeService.updateEmployee(employeeDto,EmployeeId);
    }
//    @PatchMapping("/partialUpdate/{employeeId}")
//    public EmployeeDto partialUpdateById(@RequestBody Map<String,Object> updates,@PathVariable Long employeeId){
//        return employeeService.partiallyUpdateEmployee(employeeId,updates);
//    }
}



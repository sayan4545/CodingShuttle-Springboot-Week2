package com.springbootweb.springboot.web.services;

import com.springbootweb.springboot.web.dto.EmployeeDto;
import com.springbootweb.springboot.web.entities.EmployeeEntity;
import com.springbootweb.springboot.web.repositories.Employeerepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Employeerepository employeerepository;
    private final ModelMapper modelMapper;

    public EmployeeService(Employeerepository employeerepository, ModelMapper modelMapper) {
        this.employeerepository = employeerepository;
        this.modelMapper = modelMapper;
    }
    public EmployeeDto getEmployeeById(long id){
        EmployeeEntity newEmployee = employeerepository.findById(id).orElse(null);
        ModelMapper mapper = new ModelMapper();
        return mapper.map(newEmployee,EmployeeDto.class);
    }
    public List<EmployeeDto> getAllEmployees(){
        List<EmployeeEntity> newList = employeerepository.findAll();
        return newList.stream().map(employeeEntity->modelMapper.map(newList,EmployeeDto.class)).collect(Collectors.toList());
    }
    public EmployeeDto saveEmployee(EmployeeDto employee){
        EmployeeEntity tosaveEmployeeEntity = modelMapper.map(employee,EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeerepository.save(tosaveEmployeeEntity);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployeeEntity,EmployeeDto.class);
        return savedEmployeeDto;
    }
}

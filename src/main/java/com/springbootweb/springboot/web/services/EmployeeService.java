package com.springbootweb.springboot.web.services;

import com.springbootweb.springboot.web.dto.EmployeeDto;
import com.springbootweb.springboot.web.entities.EmployeeEntity;
import com.springbootweb.springboot.web.repositories.Employeerepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

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

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long employeeId) {
        EmployeeEntity newEmployeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
        newEmployeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeerepository.save(newEmployeeEntity);
        return  modelMapper.map(savedEmployeeEntity,EmployeeDto.class);

    }

    public EmployeeDto partiallyUpdateEmployee(Long employeeId, Map<String, Object> updates) {
        boolean isPresent = employeerepository.existsById(employeeId);
        if(!isPresent) return null;
        EmployeeEntity newEmployeeEntity = employeerepository.findById(employeeId).get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
            if (fieldToBeUpdated != null) {
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, newEmployeeEntity, value);
            }
        });
        return modelMapper.map(employeerepository.save(newEmployeeEntity),EmployeeDto.class);
    }
}

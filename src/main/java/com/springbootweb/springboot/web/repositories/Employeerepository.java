package com.springbootweb.springboot.web.repositories;

import com.springbootweb.springboot.web.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepository extends JpaRepository<EmployeeEntity,Long> {
}

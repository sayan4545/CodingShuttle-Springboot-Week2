package com.springbootweb.springboot.web.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EmployeeDto {
    private long id;
    @NotNull(message = "name field is required")
    private String name;
    private boolean isActive;
    private LocalDate doj;

    public EmployeeDto(long id, LocalDate doj, boolean isActive, String name) {
        this.id = id;
        this.doj = doj;
        this.isActive = isActive;
        this.name = name;
    }

    public EmployeeDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

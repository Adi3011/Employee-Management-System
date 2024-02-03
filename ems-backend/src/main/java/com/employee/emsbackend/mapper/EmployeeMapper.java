package com.employee.emsbackend.mapper;

import com.employee.emsbackend.dto.EmployeeDto;
import com.employee.emsbackend.entity.Employee;

//map employee jpa entity to employeeDto
public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );

    }
// map employeeDto to employee jpa entity
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );

    }
}

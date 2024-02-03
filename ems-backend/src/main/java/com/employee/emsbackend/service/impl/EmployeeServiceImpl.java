package com.employee.emsbackend.service.impl;

import com.employee.emsbackend.dto.EmployeeDto;
import com.employee.emsbackend.entity.Employee;
import com.employee.emsbackend.exception.ResourseNotFoundException;
import com.employee.emsbackend.mapper.EmployeeMapper;
import com.employee.emsbackend.repository.EmployeeRepository;
import com.employee.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service  // tells spring container to create spring bean for this class
@AllArgsConstructor // for constructor based dependency injection
public class EmployeeServiceImpl  implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee= employeeRepository.save(employee); // to save it to db
        return EmployeeMapper.mapToEmployeeDto(savedEmployee); // to return saved employeeDto back to client
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourseNotFoundException("Employee does not exist with given Id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
       List<Employee> employees = employeeRepository.findAll();
       List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee: employees) {
            EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId,EmployeeDto updateEmployeeDto) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(
                        () -> new ResourseNotFoundException("Employee with id : " + employeeId + " does not exist in db")
                );
        if(updateEmployeeDto.getFirstName()!=null){
            employee.setFirstName(updateEmployeeDto.getFirstName());
        }
        else{
            employee.setFirstName(employee.getFirstName());
        }

        if(updateEmployeeDto.getLastName()!=null){
            employee.setLastName(updateEmployeeDto.getLastName());
        }
        else{
            employee.setLastName(employee.getLastName());
        }

        if(updateEmployeeDto.getFirstName()!=null){
            employee.setEmail(updateEmployeeDto.getEmail());
        }
        else {
            employee.setEmail(employee.getEmail());
        }

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(
                ()-> new ResourseNotFoundException("Employee with id : "+ employeeId +" does not exist")
        );
       employeeRepository.deleteById(employeeId);
    }

}

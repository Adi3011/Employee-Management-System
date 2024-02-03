package com.employee.emsbackend.controller;

import com.employee.emsbackend.dto.EmployeeDto;
import com.employee.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// between client and service layer exist controller layer and is dependent on service layer
@CrossOrigin("*")// to avoid cors issue
@RestController  // this class becomes spring mvc rest controller to handles rest request
@RequestMapping("/api/employees")  // to define base url for all the rest apis
@AllArgsConstructor // to initialize employeeService
public class EmployeeController {

    private EmployeeService employeeService;

    //build ADD employee REST API
    @PostMapping("/createEmployee") // to map incoming http post request to this method
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        // @RequestBody will extract json from the body of the request and convert it into EmployeeDto object
       EmployeeDto savedEmployee =  employeeService.createEmployee(employeeDto);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // build get employee by id REST API
    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById( @PathVariable("id") Long employeeId){
        //@PathVariable annotation bind path variable id to parameter employeeId
        EmployeeDto employeeDto= employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeDtos);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployeeDto =  employeeService.updateEmployee(employeeId,employeeDto);
        return ResponseEntity.ok(updatedEmployeeDto);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}

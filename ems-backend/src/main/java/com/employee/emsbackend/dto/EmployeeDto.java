package com.employee.emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// we use this class to transfer data between client and server
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}

package com.sushant.SecurityApp.SecurityApplication.clients;

import com.sushant.SecurityApp.SecurityApplication.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee);
}

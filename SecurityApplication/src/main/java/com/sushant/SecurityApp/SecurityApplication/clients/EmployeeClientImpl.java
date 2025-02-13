package com.sushant.SecurityApp.SecurityApplication.clients;

import com.sushant.SecurityApp.SecurityApplication.advice.ApiResponse;
import com.sushant.SecurityApp.SecurityApplication.dto.EmployeeDTO;
import com.sushant.SecurityApp.SecurityApplication.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeClientImpl implements EmployeeClient{

    private final RestClient restClient;

    private final Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);
    

    @Override
    public List<EmployeeDTO>
    getAllEmployees() {
        log.trace("Trying to fetch all the employees using getAllEmployees");
        try{
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get().
                    uri("employees").
                    retrieve().
                    body(new ParameterizedTypeReference<>() {
                    });
            log.info("successfully retrieve all the employess");
            return employeeDTOList.getData();
        } catch (Exception e) {
            log.error("Exception occurs while fetching all the employees ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        log.trace("Trying to fetch Employee with id {}", employeeId);
        try{
            log.info("Trying to fetch employee by id {}",employeeId);
            ApiResponse<EmployeeDTO> employeeResponse = restClient.get().
                    uri("employees/{employeeID}", employeeId).
                    retrieve().onStatus(HttpStatusCode::is4xxClientError,((request, response) -> {
                        log.error(new String(response.getBody().readAllBytes()));
                    })).
                    body(new ParameterizedTypeReference<>() {
                    });
            return employeeResponse.getData();
        } catch (Exception e) {
            log.error("Failed to fetch employee by id{}", employeeId);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        log.trace("Trying to create new Employee with information {}", inputEmployee);
        try{
            log.info("Trying to create employee");
            ApiResponse<EmployeeDTO> employeeResponse = restClient.post().
                    uri("employees").
                    body(inputEmployee).
                    retrieve().onStatus(HttpStatusCode::is4xxClientError, (req, res)-> {
                        System.out.println(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("couldnot create a new employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
            });
            return employeeResponse.getData();
        } catch (Exception e) {
            log.error("Failed to create employee by information{}", inputEmployee);
            throw new RuntimeException(e);
        }
    }
}

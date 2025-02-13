package com.sushant.SecurityApp.SecurityApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
//@Data //No more need to define a Constructor, and other

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    //Entity about employees

    private Long id;
    private String name;


    private String email;

    private Integer age;

    private LocalDate dateOfJoining;

    private String role;

    private Boolean isActive;

}

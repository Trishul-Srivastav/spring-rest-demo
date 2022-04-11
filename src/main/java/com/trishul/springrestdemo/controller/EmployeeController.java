package com.trishul.springrestdemo.controller;

import com.trishul.springrestdemo.model.EmployeeBean;
import com.trishul.springrestdemo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeBean> addEmpDetails(@RequestBody EmployeeBean employeeBean) {
        log.info("Inside EmployeeController:addEmpDetails() method");
        return new ResponseEntity<>(employeeService.addEmpDetails(employeeBean), HttpStatus.CREATED);
    }

    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeBean>> fetchAllEmpDetails() {
        log.info("Inside EmployeeController:fetchAllEmpDetails() method");
        return new ResponseEntity<>(employeeService.fetchAllEmpDetails(), HttpStatus.OK);
    }

    @GetMapping(value = "/employees/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeBean> fetchEmpDetailsById(@PathVariable("empId") Integer empId) {
        log.info("Inside EmployeeController:fetchEmpDetailsById() method");
        return new ResponseEntity<>(employeeService.getEmpById(empId), HttpStatus.OK);
    }


}

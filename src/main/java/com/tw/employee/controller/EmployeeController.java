package com.tw.employee.controller;

import com.tw.employee.model.Employee;
import com.tw.employee.model.Recommendation;
import com.tw.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/employee") // Global request mapping how it helps
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //Creates a new POST/Employee resource: http://localhost:8080/employee
    @PostMapping("")
    public Employee createEmployee(@RequestBody Employee employee) {
        return null;
    }

    //Get All Employees: http://localhost:8080/employee
    @GetMapping("")
    public List<Employee> listEmployees() {
        return employeeService.listEmployees();
    }

    //Get Employee with a specific id: http://lcoalhost:8080/emploee/id2
    @GetMapping(value = "/{id}")
    public Employee listEmployees(@PathVariable String id) { // Cover what is diff between @RequestParam and @Path Variable
        return null;
    }

    //Updates a POST/Employee resource whose Id is id2: http://localhost:8080/employee/id2
    @PutMapping(value = "/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        return null;
    }

    //Get all recommendations specific Employee : http://lcoalhost:8080/emploee/id2/recommendations
    @GetMapping("/{id}/recommendations")
    public List<Recommendation> getEmployeeRecommendations(@PathVariable String id) {
        return null;
    }


    //Post specific Employee recommendations: http://lcoalhost:8080/emploee/id2/recommendations
    @ResponseStatus(HttpStatus.CREATED) // talk about what is response status and how it is Used.
    @PostMapping("/{id}/recommendations")
    public void createEmployeeRecommendations(@PathVariable String id, @RequestBody Recommendation recommendation) {

    }

    //Delete specific Employee recommendations: http://lcoalhost:8080/emploee/id2/recommendations
    @DeleteMapping("/{employeeId}/recommendations/{recommendationId}")
    public void deleteEmployeeRecommendation(@PathVariable String employeeId, @PathVariable String recommendationId) {

    }

    //perform validation using java bean validation API
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Employee createEmployee(@RequestBody @Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            //TODO - handle errors;
        }
        return employeeService.createEmployee(employee);
    }

    // Using ResponseEntity for control on responses
    public ResponseEntity<Employee> createEmployeeRE(@RequestBody @Valid Employee employee, BindingResult result) {
        Employee createdEmp = createEmployee(employee, result);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("userRespHeader1","value1");
        responseHeaders.set("userRespHeader2","value2");
        return new ResponseEntity<>(createdEmp, responseHeaders, HttpStatus.CREATED);
    }
}

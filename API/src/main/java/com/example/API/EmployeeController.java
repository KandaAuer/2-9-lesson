package com.example.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/departments/max-salary")
    public ResponseEntity<Employee> getMaxSalaryEmployee(@RequestParam String departmentId) {
        return employeeService.getMaxSalaryEmployee(departmentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/departments/min-salary")
    public ResponseEntity<Employee> getMinSalaryEmployee(@RequestParam String departmentId) {
        return employeeService.getMinSalaryEmployee(departmentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/departments/all")
    public ResponseEntity<?> getAllEmployeesByDepartment(@RequestParam(required = false) String departmentId) {
        if (departmentId != null) {
            return ResponseEntity.ok(employeeService.getAllEmployeesByDepartment(departmentId));
        } else {
            Map<String, List<Employee>> allEmployeesGroupedByDepartment = employeeService.getAllEmployeesGroupedByDepartment();
            return ResponseEntity.ok(allEmployeesGroupedByDepartment);
        }
    }
}

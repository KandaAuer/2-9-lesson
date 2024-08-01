package com.example.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private OldEmployeeService oldEmployeeService;

    public Optional<Employee> getMaxSalaryEmployee(String departmentId) {
        return oldEmployeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalary));
    }

    public Optional<Employee> getMinSalaryEmployee(String departmentId) {
        return oldEmployeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .min(Comparator.comparingInt(Employee::getSalary));
    }

    public List<Employee> getAllEmployeesByDepartment(String departmentId) {
        return oldEmployeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .collect(Collectors.toList());
    }

    public Map<String, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return oldEmployeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}

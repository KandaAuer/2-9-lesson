package com.example.API;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OldEmployeeService {

    public List<Employee> getAllEmployees() {
        return Arrays.asList(
                new Employee(1, "Изуки", 70000, "IT"),
                new Employee(2, "Арина", 80000, "HR"),
                new Employee(3, "Александр", 90000, "IT"),
                new Employee(4, "Давид", 50000, "Finance"),
                new Employee(5, "Ева", 75000, "HR")
        );
    }
}

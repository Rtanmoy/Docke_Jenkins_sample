package java8.stream.dao;

import java8.stream.model.Employee;

import java.util.List;
import java.util.stream.Collectors;



public class TaxService {

    public static List<Employee> evaluateTaxUsers(String input){
        return input.equalsIgnoreCase("tax")
        ?EmployeeService.getEmployees().stream().filter(emp->emp.getSlary()>50000)
                .collect(Collectors.toList()):EmployeeService.getEmployees().stream().filter(emp->emp.getSlary()<=50000).collect(Collectors.toList());
    }
    public static void main(String[] args) {
     System.out.println(evaluateTaxUsers("non tax"));
    }
}

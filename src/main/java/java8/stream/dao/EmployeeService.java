 package java8.stream.dao;

import java8.stream.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public static List<Employee> getEmployees(){

        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee(123,"Rama","IT",60000));
        employees.add(new Employee(223,"Mona","CSE",50000));
        employees.add(new Employee(143,"Aman","EE",90000));
        employees.add(new Employee(163,"Maya","CORE",40000));
        employees.add(new Employee(127,"Babai","SOCIAL",120000));
        return employees;
    }

}

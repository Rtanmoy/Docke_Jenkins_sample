package java8;


import java8.stream.cheatsheet.model.Employee;
import java8.stream.cheatsheet.project.EmployeeDataBase;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.BinaryOperator.maxBy;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;

public class FindFrequencyOfCharacter {
    public static void main(String[] args) {
        String str="Tanmoy";
        Map<String,Long> count=Arrays.stream(str.split("")).collect(groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(count);

        List<Employee> employeeList= EmployeeDataBase.getAllEmployees();
        Map<Double, Optional<Employee>> salaryGroup = employeeList.stream()
                .collect(groupingBy(Employee::getSalary,
                        Collectors.reducing(maxBy(Comparator.comparing(Employee::getSalary)))));
        System.out.println(salaryGroup);

       /* employeeList.stream().collect(
                groupingBy(Employee::getSalary,
                        collectingAndThen(maxBy(Comparator.comparingDouble(Employee::getSalary))),Optional::get));*/

    }
}

package java8.stream.cheatsheet.project;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;  

import java8.stream.cheatsheet.model.Employee;

public class Practice {
	public static void main(String[] args) {
    List<Employee> list=EmployeeDataBase.getAllEmployees();
    
    list.stream().forEach(System.out::println);
    List<Employee> developmentEmployes=list.stream().filter(e->e.getDept().equals("Development")&&e.getSalary()>65000).collect(Collectors.toList());
    System.out.println(developmentEmployes);
    Map<Integer,String> developmentEmployesMap=list.stream().filter(e->e.getDept().equals("Development")&&e.getSalary()>65000).collect(Collectors.toMap(Employee::getId,Employee::getName));
    System.out.println(developmentEmployesMap);
    list.stream().map(e->e.getDept()).collect(Collectors.toList());
    //List<String> projectName=list.stream().flatMap(e->e.getProjects().stream().map(p->p.getName())).collect(Collectors.toList());
    
    //sort
    list.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
    list.stream().sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary))).collect(Collectors.toList());
    list.stream().max(Comparator.comparingDouble(Employee::getSalary));
    list.stream().collect(Collectors.groupingBy(Employee::getGender));
    list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.mapping(Employee::getName, Collectors.toList())));
    list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
    
	}
}

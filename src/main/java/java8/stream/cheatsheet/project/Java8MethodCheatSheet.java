package java8.stream.cheatsheet.project;



import java8.stream.cheatsheet.model.Employee;
import java8.stream.cheatsheet.model.Project;

import java.util.*;
import java.util.stream.Collectors;

public class Java8MethodCheatSheet {
    public static void main(String[] args) {

        List<Employee> employeeList=EmployeeDataBase.getAllEmployees();

        System.out.println("===============>> forEach <<============");
        //forEach()
        employeeList.stream().forEach(e->System.out.println(e.getName()+"  =====>> "+e.getSalary()));

        System.out.println("===============>> filter <<============");
        //filter()
        employeeList.stream().filter(emp->emp.getDept().equalsIgnoreCase("Development") && emp.getSalary()>85000.0).forEach(e->System.out.println(e.getName()+"  =====>> "+e.getSalary()));

        System.out.println("===============>> Collect <<============");
        //collect
        Map<Integer,String> mapEmployee=employeeList.stream().filter(emp->emp.getDept().equalsIgnoreCase("Development") && emp.getSalary()>85000.0).collect(Collectors.toMap(Employee::getId,Employee::getName));
        //System.out.println(mapEmployee);

        System.out.println("===============>> map() <<============");
        //map()
        List<String> listEmployee=employeeList.stream().map(Employee::getDept).collect(Collectors.toList());
        System.out.println(listEmployee);

        System.out.println("===============>> disinct() <<============");
        //distinct()
        List<String> disEmployee=employeeList.stream().map(Employee::getDept).distinct().collect(Collectors.toList());
        System.out.println(disEmployee);

        Set<String> setEmployee=employeeList.stream().map(Employee::getDept).collect(Collectors.toSet());
        System.out.println(setEmployee);

        System.out.println("===============>> flatMap <<============");
        //flatMap()
        List<String> getNameFromProject=employeeList.stream().flatMap(pro->pro.getProjects().stream())
                .map(p->p.getName()).distinct().collect(Collectors.toList());
        System.out.println(getNameFromProject);

        System.out.println("===============>> sorted <<============");
        //sorted()
        //ascending order
        List<String> sortgetNameFromProject=employeeList.stream().flatMap(pro->pro.getProjects().stream())
                .map(p->p.getName()).sorted().distinct().collect(Collectors.toList());
        System.out.println(sortgetNameFromProject);

        List<Employee> ascsortgetName=employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName)).distinct().collect(Collectors.toList());
        System.out.println(ascsortgetName);

        List<Employee> descsortgetName=employeeList.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Employee::getName))).distinct().collect(Collectors.toList());
        System.out.println(descsortgetName);

        System.out.println("===============>> min/max <<============");
        //min()/max()
        Optional<Employee> minSalary=employeeList.stream()
                .min(Comparator.comparing(Employee::getSalary));
        System.out.println("Min Salary ==> "+minSalary);

        Optional<Employee> maxSalary=employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println("Max Salary ==> "+maxSalary);

        System.out.println("===============>> groupingBy <<============");
        //groupingBy
       Map<String,List<Employee>> groupByGender=employeeList.stream().collect(Collectors.groupingBy(Employee::getGender));
        System.out.println(groupByGender);

        //Gender->[name]
        Map<String,List<String>> groupByGender1=employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.mapping(Employee::getName,Collectors.toList())));
        System.out.println(groupByGender1);

        //Gender->[name]
        Map<String, Long> groupByGenderCount=employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(groupByGenderCount);

        System.out.println("===============>> findFirst <<============");
        //fndFirst()
        Optional<Employee> empFirst=employeeList.stream().filter(emp->emp.getDept().equals("Development")).findFirst();
        System.out.println(empFirst.get());

        empFirst.ifPresent(e->System.out.println(e.getName()));
        Employee empFirstElse=employeeList.stream()
                .filter(emp->emp.getDept().equals("Development")).findFirst().orElseThrow(()->new IllegalArgumentException("Record not found"));
        System.out.println(empFirstElse);

        System.out.println("===============>> findAny <<============");
        //fndAny()
        Employee empAny=employeeList.stream()
                .filter(emp->emp.getDept().equals("Development")).findAny().orElseThrow(()->new IllegalArgumentException("Record not found"));
        System.out.println(empAny);

        System.out.println("===============>> anyMatch/allmatch/noneMatch <<============");
        //anyMatch/allmatch/noneMatch()
        boolean empanyMatch=employeeList.stream()
                .anyMatch(emp->emp.getDept().equals("Development"));
        System.out.println(empanyMatch);

        boolean empAllMatch=employeeList.stream()
                .allMatch(emp->emp.getSalary()>50000);
        System.out.println(empAllMatch);

        boolean empNonMatch=employeeList.stream()
                .noneMatch(emp->emp.getDept().equals("Development"));
        System.out.println(empNonMatch);

        System.out.println("===============>> limit <<============");
        //limit(long)
        List<Employee> empLimit=employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).collect(Collectors.toList());

        System.out.println(empLimit);

        System.out.println("===============>> skip <<============");
        //skip(long)
        List<Employee> empSkip=employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(3).collect(Collectors.toList());

        System.out.println(empSkip);


    }
}

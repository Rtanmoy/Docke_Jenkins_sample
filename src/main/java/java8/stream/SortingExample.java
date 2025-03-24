package java8.stream;

import java8.stream.dao.EmployeeService;
import java8.stream.model.Employee;

import java.util.*;

public class SortingExample {

    public static void main(String[] args) {

        List<Employee> employeeList= EmployeeService.getEmployees();
        Collections.sort(employeeList,(s1,s2)->(int)(s1.getSlary()-s2.getSlary()));
        System.out.println(employeeList);
        employeeList.stream().sorted();
        System.out.println(employeeList);
        employeeList.stream().sorted((Comparator.comparing(emp->emp.getSlary()))).forEach(System.out::println);
        employeeList.stream().sorted((Comparator.comparing(Employee::getName))).forEach(System.out::println);

        System.out.println("==============================>>> MAP <<<===============================");

        Map<String,Integer>map=new HashMap<>();
        map.put("ADC",123);
        map.put("JDC",223);
        map.put("WWC",523);
        map.put("CCC",133);
        map.put("GDC",323);

        List<Map.Entry<String,Integer>> entries=new ArrayList<>(map.entrySet());
        Collections.sort(entries,(o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        System.out.println("==============================>>><<<===============================");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        Map<Employee,Integer> employeeIntegerMap=new TreeMap<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int)(o1.getSlary()-o2.getSlary());
            }
        });
        employeeIntegerMap.put(new Employee(123,"Rama","IT",60000),20);
        employeeIntegerMap.put(new Employee(223,"Mona","CSE",50000),70);
        employeeIntegerMap.put(new Employee(143,"Aman","EE",90000),80);
        employeeIntegerMap.put(new Employee(163,"Maya","CORE",40000),50);
        employeeIntegerMap.put(new Employee(127,"Babai","SOCIAL",120000),20);

        System.out.println(employeeIntegerMap);

        employeeIntegerMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName))).forEach(System.out::println);
        employeeIntegerMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName).reversed())).forEach(System.out::println);

    }
}

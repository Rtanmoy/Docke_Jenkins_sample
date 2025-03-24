package java8.stream;

import java8.stream.dao.EmployeeService;
import java8.stream.model.Employee;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamEx {
    public static void main(String[] args) {
        long start=0;
        long end=0;

        start=System.currentTimeMillis();
        IntStream.range(1,50).forEach(System.out::println);
        end=System.currentTimeMillis();
        System.out.println("Normal Stream => "+(end-start));
        System.out.println("================");

        start=System.currentTimeMillis();
        IntStream.range(1,50).parallel().forEach(System.out::println);
        end=System.currentTimeMillis();
        System.out.println("Parallel Stream => "+(end-start));

        List<Employee> employeeList= EmployeeService.getEmployees();
        Double averageSalary=employeeList.stream().map(Employee::getSlary).mapToDouble(i->i).average().getAsDouble();
        System.out.println(averageSalary);

        Double sumSalary=employeeList.stream().map(Employee::getSlary).mapToDouble(i->i).sum();
        System.out.println(sumSalary);
    }
}

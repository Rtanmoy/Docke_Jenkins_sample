package java8.stream;

import java8.stream.dao.Customer;
import java8.stream.dao.CustomerDB;

import java.util.List;
import java.util.stream.Collectors;

public class MapvsFlatMap {
    public static void main(String[] args) {
        List<Customer> customers= CustomerDB.getCustomers();
        customers.stream().map(emp->emp.getEmail()).collect(Collectors.toList());
        System.out.println(customers);

       List<List<Integer>> phoneNumbers=customers.stream().map(emp->emp.getMobileno()).collect(Collectors.toList());
        System.out.println(phoneNumbers);

        List<Integer> phoneNumbers1=customers.stream().flatMap(customer->customer.getMobileno().stream()).collect(Collectors.toList());
        System.out.println(phoneNumbers1);

    }
}

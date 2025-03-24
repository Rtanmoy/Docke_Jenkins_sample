package java8.stream.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerDB {

    public static List<Customer> getCustomers(){
        return Stream.of(
                new Customer(12,"Sagar","sagar@gmail.com", Arrays.asList(12341,456321)),
                new Customer(42,"Ragar","Ragar@gmail.com", Arrays.asList(87641,456901)),
                new Customer(11,"Uttar","Uttar@gmail.com", Arrays.asList(97341,678321)),
                new Customer(10,"Gharr","Gharr@gmail.com", Arrays.asList(43341,498721)),
                new Customer(9,"War","War@gmail.com", Arrays.asList(77641,900321))
                ).collect(Collectors.toList());
    }
}

package java8.stream;

import java8.stream.dao.Customer;
import java8.stream.dao.CustomerDB;

import java.util.Arrays;
import java.util.Optional;

public class OptionalDemo {

    public static Customer getCustomerEmail(String email){
      return CustomerDB.getCustomers().stream().filter(customer->customer.getEmail().equals(email))
                      .findAny().orElse(new Customer());
    }
    public static void main(String[] args) {
        Customer customer=new Customer(12,"Sagar",null, Arrays.asList(12341,456321));
        //empty
        //of
        //ofNullable
        Optional<Object> optional=Optional.empty();
        System.out.println(optional);

        //Optional<String> optional1=Optional.of(customer.getEmail());
       // System.out.println(optional1);

       // Optional<String>optional2=Optional.ofNullable(customer.getEmail());
     //   System.out.println(optional2.orElse("email does not present"));
     //   System.out.println(optional2.map(String::toUpperCase).orElseGet(()->"email does not present"));

        getCustomerEmail("abc");
    }
}

package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SomeInterfacesEx {

    public static void main(String[] args) {
      /*  Consumer<Integer> consumer=t-> System.out.println("Printing : "+t);
        consumer.accept(10);*/

        //list.stream().forEach(consumer);
        List<Integer> list=Arrays.asList(1,2,3,4,5);
        list.stream().forEach(t -> System.out.println("Printing : " + t));

        Predicate<Integer> predicate=t->t%2==0;

        System.out.println(predicate.test(5));

        list.stream().filter(predicate).forEach(t -> System.out.println("Printing : " + t));

        Supplier<String> supplier=()->"Hello world";
        Supplier<Integer> supplier1=()->1;
        System.out.println(supplier.get());
        System.out.println(list.stream().findAny().orElseGet(supplier1));
    }
}

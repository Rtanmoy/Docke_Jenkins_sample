package java8.stream;

import java8.stream.dao.EmployeeService;
import java8.stream.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceEx {
    public static void main(String[] args) {

        List<Integer> numbers= Arrays.asList(2,6,8,9,22);
        int sum=0;
        for(int num:numbers){
            sum=sum+num;
        }
        System.out.println(sum);

       int sum1= numbers.stream().mapToInt(i->i).sum();
        System.out.println(sum1);

        int sumWithReduce= numbers.stream().reduce(0,(a,b)->a+b);
        System.out.println(sumWithReduce);

        Optional<Integer> sumWithReduce1= numbers.stream().reduce(Integer::sum);
        System.out.println(sumWithReduce1.get());

        int maxnum= numbers.stream().reduce(0,(a,b)->a>b?a:b);
        System.out.println(maxnum);

        Integer maxnum1= numbers.stream().reduce(Integer::max).get();
        System.out.println(maxnum1);


        List<String> str=Arrays.asList("Bangalore","Bhopal","Sonarpur");
        String longestString=str.stream().reduce((a,b)->a.length()>b.length()?a:b).get();
        System.out.println(longestString);

    }
}

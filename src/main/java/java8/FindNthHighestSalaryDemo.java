package java8;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindNthHighestSalaryDemo {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("AVD",23000);
        map.put("WQVD",13000);
        map.put("ASD",26000);
        map.put("DDD",43000);
        map.put("XXD",73000);
        map.put("GRW",8000);


        Map.Entry<String,Integer>result=getNthHighestSalary(2,map);
        System.out.println(result);

        Map<String,Integer> map1=new HashMap<>();
        map1.put("AVD",13000);
        map1.put("WQVD",13000);
        map1.put("ASD",26000);
        map1.put("DDD",26000);
        map1.put("XXD",8000);
        map1.put("GRW",8000);

        Map.Entry<String,Integer>result1=getNthHighestSalary(2,map1);
        System.out.println(result1);

         Map<Integer,List<String>> map2 = map1.entrySet().stream()
                .collect(Collectors
                        .groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println(map2);

        System.out.println(getDynamicNthHighestSalary(2,map1));

    }

    public static Map.Entry<Integer, List<String>> getDynamicNthHighestSalary(int num, Map<String, Integer> map) {
        return map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(num - 1);
    }
    public static Map.Entry<String,Integer> getNthHighestSalary(int num,Map<String,Integer> map){
        return map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList()).get(num-1);
    }
}

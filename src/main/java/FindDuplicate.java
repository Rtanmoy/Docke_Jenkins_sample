import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDuplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicateUsingFor("Array")); //complexity=o(n2)
        System.out.println(findDuplicateUsingMap("Array"));
    }

    private static Set<Character> findDuplicateUsingMap(String str) {
        Set<Character> set=new HashSet<>();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length()-1;i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
       for(Map.Entry<Character,Integer> ele: map.entrySet()){
           if(ele.getValue()>1){
               set.add(ele.getKey());
           }
       }
       return set;
    }

    private static Set<Character> findDuplicateUsingFor(String string) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<string.length()-1;i++){
            for(int j=i+1;j<string.length();j++){
                if(string.charAt(i)==string.charAt(j)){
                    set.add(string.charAt(j));
                }
            }
        }
        return set;
    }
}

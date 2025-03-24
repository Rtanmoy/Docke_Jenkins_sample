import java.util.HashSet;
import java.util.Set;

public class Isogram {

    public static void main(String[] args) {
        System.out.println((isogram("Array")));
    }

    private static boolean isogram(String s) {

        boolean flag=true;
        char[] ch=s.toCharArray();
        Set<Character> set=new HashSet<>();
        for(char c:ch){
            if(set.contains(c)){
                flag=false;
            } else{
                set.add(c);
            }
        }
        return flag;
    }
}

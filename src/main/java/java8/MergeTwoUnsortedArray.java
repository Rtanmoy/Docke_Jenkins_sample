package java8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoUnsortedArray {

    public static void main(String[] args) {
        int[] a={3,7,4,9};
        int[] b={8,2,1,5};

        int result []=IntStream.concat(Arrays.stream(a),Arrays.stream(b)).sorted().toArray();

       for (int i:result){
           System.out.print(i+" ");
       }
    }
}

public class FindNthElementFibo {
    public static void main(String[] args) {
        System.out.println(fibo(2));
    }

    private static int fibo(int n) {
        if(n<=1)
            return  n;
         else
            return fibo(n-1)+fibo(n-2);
    }
}
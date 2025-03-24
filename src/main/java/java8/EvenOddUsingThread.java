package java8;

public class EvenOddUsingThread implements Runnable{

    static int count=1;
    Object object;

    public EvenOddUsingThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {

        while (count <= 10) {
            if (count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
            synchronized (object){
                System.out.println("ThreadName "+Thread.currentThread().getName()+" Value : "+count);
                count++;
                try {
                    object.wait();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            }

            if (count % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object){
                    System.out.println("ThreadName "+Thread.currentThread().getName()+" Value : "+count);
                    count++;
                    object.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object object=new Object();
        Runnable r1=new EvenOddUsingThread(object);
        Runnable r2=new EvenOddUsingThread(object);

        new Thread(r1,"even").start();
        new Thread(r2,"odd").start();
    }
}

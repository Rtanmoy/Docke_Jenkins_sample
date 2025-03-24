public class SingletonDP {
    public static void main(String[] args) {
        SingletonClass ob1= SingletonClass.getInstance();
        SingletonClass ob2=SingletonClass.getInstance();

        System.out.println(ob1);
        System.out.println(ob1);

    }
}
class SingletonClass {

    private static SingletonClass instance = null;

    private SingletonClass() {

    }

    public static synchronized SingletonClass getInstance() {

        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }
}

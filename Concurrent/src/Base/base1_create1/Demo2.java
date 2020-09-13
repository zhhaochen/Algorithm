package Base.base1_create1;

/**
 * 实现Runnable接口
 * 可以看到Runnable是一个函数式接口，这意味着我们可以使用Java 8的函数式编程来简化代码。
 */
public class Demo2 {
    public static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread Runnable");
        }
    }

    public static void main(String[] args) {
        new Thread(new MyThread()).start();

        // Java 8 函数式编程，可以省略MyThread类
        new Thread(() -> {
            System.out.println("Java 8 匿名内部类");
        }).start();
    }
}

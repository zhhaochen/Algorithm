package Base.base5_communication;

/**
 * ThreadLocal是一个本地线程副本变量工具类。内部是一个弱引用的Map来维护。
 * ThreadLocal类让每个线程有自己”独立“的变量，线程之间互不影响。它为每个线程都创建一个副本，每个线程可以访问自己内部的副本变量。
 * ThreadLocal类最常用的就是set方法和get方法
 */
public class ThreadLocalDemo {
    static class ThreadA implements Runnable {
        private ThreadLocal<String> threadLocal;

        public ThreadA(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadA输出：" + threadLocal.get());
        }

        static class ThreadB implements Runnable {
            private ThreadLocal<String> threadLocal;

            public ThreadB(ThreadLocal<String> threadLocal) {
                this.threadLocal = threadLocal;
            }

            @Override
            public void run() {
                threadLocal.set("B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadB输出：" + threadLocal.get());
            }
        }

        public static void main(String[] args) {
            /**
             * 虽然两个线程使用的同一个ThreadLocal实例，但是它们各自可以存取自己当前线程的一个值。
             * 开发者希望将类的某个静态变量（user ID或者transaction ID）与线程状态关联，则可以考虑使用ThreadLocal。
             * 最常见的ThreadLocal使用场景为用来解决数据库连接、Session管理等。
             * 数据库连接和Session管理涉及多个复杂对象的初始化和关闭。
             * 如果在每个线程中声明一些私有变量来进行操作，那这个线程就变得不那么“轻量”了，需要频繁的创建和关闭连接。
             */
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            new Thread(new ThreadA(threadLocal)).start();
            new Thread(new ThreadB(threadLocal)).start();
        }
    }
}

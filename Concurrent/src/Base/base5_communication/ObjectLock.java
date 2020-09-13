package Base.base5_communication;

/**
 * 对象锁示例
 * Java中，锁的概念都是基于对象的，所以我们又经常称它为对象锁。
 * 线程同步是线程之间按照一定的顺序执行。
 *
 * 等A先执行完之后，再由B去执行
 */
public class ObjectLock {
    private static Object lock = new Object();

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread A " + i);
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread B " + i);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        // 在主线程里使用sleep方法睡眠了10毫秒，是为了防止线程B先得到锁。
        Thread.sleep(10);
        new Thread(new ThreadB()).start();
    }
}

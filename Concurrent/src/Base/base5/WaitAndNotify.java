package Base.base5;

/**
 * 基于“锁”的方式，线程需要不断地去尝试获得锁，如果失败了，再继续尝试。这可能会耗费服务器资源。
 * Java多线程的等待/通知机制是基于Object类的wait()方法和notify(), notifyAll()方法来实现的。
 * notify()方法会随机叫醒一个正在等待的线程，而notifyAll()会叫醒所有正在等待的线程。
 *
 * 假如线程A现在持有了一个锁lock并开始执行，它可以使用lock.wait()让自己进入等待状态。这个时候，lock这个锁是被释放了的。
 * 线程B获得了lock这个锁并开始执行，它可以在某一时刻，使用lock.notify()，通知之前持有lock锁并进入等待状态的线程A，说“线程A你不用等了，可以往下执行了”。
 * 注意这时线程B并没有释放锁lock，除非线程B这时使用lock.wait()释放锁，或者线程B执行结束自行释放锁，线程A才能得到lock锁。
 */
public class WaitAndNotify {
    private static Object lock = new Object();

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadA: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadB: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //线程A和线程B首先打印出自己需要的东西，然后使用notify()方法叫醒另一个正在等待的线程，然后自己使用wait()方法陷入等待并释放lock锁。
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }
}

package Base.base3_group_priority;

import java.util.stream.IntStream;

/**
 * 优先级来说不是特别的可靠，
 * Java程序中对线程所设置的优先级只是给操作系统一个建议，操作系统不一定会采纳。
 * 真正的调用顺序，是由操作系统的线程调度算法决定的。
 */
public class Demo2_2 {
    public static class T1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(String.format("当前执行的线程是：%s，优先级：%d",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
        }

        public static void main(String[] args) {
            IntStream.range(1, 10).forEach(i -> {
                Thread thread = new Thread(new T1());
                thread.setPriority(i);
                thread.start();
            });
        }
    }
}

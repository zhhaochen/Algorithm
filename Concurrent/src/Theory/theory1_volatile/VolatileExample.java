package Theory.theory1_volatile;

/**
 * volatile主要有以下两个功能：
 *      - 保证变量的内存可见性
 *      - 禁止volatile变量与普通变量重排序
 * 内存可见性
 * 当一个线程对volatile修饰的变量进行写操作（比如step 2）时，JMM会立即把该线程对应的本地内存中的共享变量的值刷新到主内存；
 * 当一个线程对volatile修饰的变量进行读操作（比如step 3）时，JMM会把立即该线程对应的本地内存置为无效，从主内存中读取共享变量的值。
 */
public class VolatileExample {
    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1; // step 1
        flag = true; // step 2
    }

    public void reader() {
        if (flag) { // step 3
            System.out.println(a); // step 4
        }
    }
}


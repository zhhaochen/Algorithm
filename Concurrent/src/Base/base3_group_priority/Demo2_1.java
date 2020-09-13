package Base.base3_group_priority;

/**
 * Java中线程优先级可以指定，范围是1~10。
 * Java只是给操作系统一个优先级的参考值，线程最终在操作系统的优先级是多少还是由操作系统决定。
 * Java默认的线程优先级为5，线程的执行顺序由调度程序来决定，线程的优先级会在线程被调用之前设定。
 * 高优先级的线程将会比低优先级的线程有更高的几率得到执行，不代表一定会比低优先级先执行
 */
public class Demo2_1 {
    public static void main(String[] args) {
        Thread a = new Thread();
        System.out.println("我是默认线程优先级："+a.getPriority());
        Thread b = new Thread();
        b.setPriority(10);
        System.out.println("我是设置过的线程优先级："+b.getPriority());
    }
}

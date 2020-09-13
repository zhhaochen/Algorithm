package Theory.theory4_aqs;

/**
 * AQS是AbstractQueuedSynchronizer的简称，即抽象队列同步器，从字面意思上理解:
 * 抽象：抽象类，只实现一些主要逻辑，有些方法由子类实现；
 * 队列：使用先进先出（FIFO）队列存储数据；
 * 同步：实现了同步的功能。
 *
 * 资源有两种共享模式，或者说两种同步方式：
 * 独占模式（Exclusive）：资源是独占的，一次只能一个线程获取。如ReentrantLock。
 * 共享模式（Share）：同时可以被多个线程获取，具体的资源个数可以通过参数指定。如Semaphore/CountDownLatch。
 * AQS中关于这两种资源共享模式的定义源码（均在内部类Node中）。
 *
 * AQS的设计是基于模板方法模式的，它有一些方法必须要子类去实现的，
 * isHeldExclusively()：该线程是否正在独占资源。只有用到condition才需要去实现它。
 * tryAcquire(int)：独占方式。尝试获取资源，成功则返回true，失败则返回false。
 * tryRelease(int)：独占方式。尝试释放资源，成功则返回true，失败则返回false。
 * tryAcquireShared(int)：共享方式。尝试获取资源。负数表示失败；0表示成功，但没有剩余可用资源；正数表示成功，且有剩余资源。
 * tryReleaseShared(int)：共享方式。尝试释放资源，如果释放后允许唤醒后续等待结点返回true，否则返回false。
 */
public class demo1 {
}

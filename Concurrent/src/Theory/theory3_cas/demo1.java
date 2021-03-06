package Theory.theory3_cas;

/**
 * 乐观锁与悲观锁的概念
 * 悲观锁就是常说的锁，总是认为每次访问共享资源时会发生冲突，所以必须对每次数据操作加上锁，以保证临界区的程序同一时间只能有一个线程在执行。
 * 乐观锁又称为“无锁”，总是假设对共享资源的访问没有冲突，线程可以不停地执行，无需加锁也无需等待。旦多个线程发生冲突，通常是使用一种称为CAS的技术来保证线程执行的安全性。乐观锁天生免疫死锁。
 * 乐观锁多用于“读多写少“的环境，避免频繁加锁影响性能；而悲观锁多用于”写多读少“的环境，避免频繁失败和重试影响性能。
 *
 * CAS的概念
 * CAS的全称是：比较并交换（Compare And Swap）
 * 判断V是否等于E，如果等于，将V的值设置为N；如果不等，说明已经有其它线程更新了V，则当前线程放弃更新，什么都不做。
 * CAS是一种原子操作，它是一种系统原语，是一条CPU的原子指令，从CPU层面保证它的原子性
 * 当多个线程同时使用CAS操作一个变量时，只有一个会胜出，并成功更新，其余均会失败，但失败的线程并不会被挂起，仅是被告知失败，并且允许再次尝试，当然也允许失败的线程放弃操作
 *
 * CAS实现原子操作的三大问题
 * 1. ABA问题：一个值原来是A，变成了B，又变回了A。这个时候使用CAS是检查不出变化的，但实际上却被更新了两次。
 *    解决思路是在变量前面追加上版本号或者时间戳。JDK的atomic包里提供了一个类AtomicStampedReference类来解决ABA问题。
 * 2. 循环时间长开销大
 *    CAS多与自旋结合。如果自旋CAS长时间不成功，会占用大量的CPU资源。解决思路是让JVM支持处理器提供的pause指令。
 *    pause指令能让自旋失败时cpu睡眠一小段时间再继续自旋，从而使得读操作的频率低很多,为解决内存顺序冲突而导致的CPU流水线重排的代价也会小很多。
 * 3. 只能保证一个共享变量的原子操作，解决方法：
 *    (1)使用JDK 1.5开始就提供的AtomicReference类保证对象之间的原子性，把多个变量放到一个对象里面进行CAS操作；
 *    (2)使用锁。锁内的临界区代码可以保证只有当前线程能操作。
 */
public class demo1 {
}

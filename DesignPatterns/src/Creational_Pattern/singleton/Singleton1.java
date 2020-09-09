package Creational_Pattern.singleton;

/**
 * 懒汉式-线程不安全
 * 在多线程环境下是不安全的，如果多个线程能够同时进入 if (uniqueInstance == null) ，
 * 并且此时 uniqueInstance 为 null，那么会有多个线程执行 uniqueInstance = new Singleton(); 语句，
 * 这将导致实例化多次 uniqueInstance。
 */
public class Singleton1 {
    private static Singleton1 uniqueInstance;

    private Singleton1() {
    }

    public static Singleton1 getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton1();
        }
        return uniqueInstance;
    }
}

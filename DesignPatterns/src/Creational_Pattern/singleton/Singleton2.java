package Creational_Pattern.singleton;

/**
 * 饿汉式-线程安全
 * 直接实例化 uniqueInstance 的方式就不会产生线程不安全问题
 * 但是直接实例化的方式也丢失了延迟实例化带来的节约资源的好处。
 */
public class Singleton2 {

    private static Singleton2 uniqueInstance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getUniqueInstance() {
        return uniqueInstance;
    }
}

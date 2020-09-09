package Creational_Pattern.singleton;

/**
 * 懒汉式-线程安全
 * 对getUniqueInstance方法加锁
 * 这会让线程阻塞时间过长，因此该方法有性能问题，不推荐使用。
 */
public class Singleton3 {
    private static Singleton3 uniqueInstance;

    private Singleton3() {
    }

    public static synchronized Singleton3 getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton3();
        }
        return uniqueInstance;
    }
}

package Creational_Pattern.singleton;

/**
 * 懒汉式-双重校验锁-线程安全
 * 只有当 uniqueInstance 没有被实例化时，才需要进行加锁。
 * 加锁后再校验一次
 * 采用 volatile 关键字修饰也是很有必要的， uniqueInstance = new Singleton(); 这段代码其实是分为三步执行：
 * 1.为 uniqueInstance 分配内存空间
 * 2.初始化 uniqueInstance
 * 3.将 uniqueInstance 指向分配的内存地址
 * JVM 具有指令重排的特性，执行顺序有可能变成 1>3>2。在多线程环境下会导致一个线程获得还没有初始化的实例
 */
public class Singleton4 {
    private volatile static Singleton4 uniqueInstance;

    private Singleton4(){

    }

    public static synchronized Singleton4 getUniqueInstance(){
        if (uniqueInstance == null){
            synchronized (Singleton4.class){
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton4();
                }
            }
        }
        return uniqueInstance;
    }
}

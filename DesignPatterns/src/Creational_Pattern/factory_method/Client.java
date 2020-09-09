package Creational_Pattern.factory_method;

public class Client {
    public static void main(String[] args) {
        // 客户决定使用哪个子工厂
        Factory factory = new ConcreteFactory();
        // 子工厂生产产品进一步用于其他操作
        factory.doSomething();
    }
}

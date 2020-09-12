package Structural_Pattern.flyweight;

/**
 * 享元模式
 * 利用共享的方式来支持大量细粒度的对象，这些对象一部分内部状态是相同的。
 */
public class Client {

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweight1 = factory.getFlyweight("aa");
        Flyweight flyweight2 = factory.getFlyweight("aa");
        flyweight1.doOperation("x");
        flyweight2.doOperation("y");
    }
}

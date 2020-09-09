package Creational_Pattern.prototype;

public class Client {
    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype("abc");
        // 注意这里有深拷贝和浅拷贝的区别
        Prototype clone = prototype.myClone();
        System.out.println(clone.toString());
    }
}

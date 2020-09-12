package Behavioral_Pattern.strategy;

public class Client {
    public static void main(String[] args) {
        Duck duck = new Duck();
        // 鸭子自己选择叫声算法
        duck.setQuackBehavior(new Squeak());
        duck.performQuack();
        duck.setQuackBehavior(new Quack());
        duck.performQuack();
    }
}

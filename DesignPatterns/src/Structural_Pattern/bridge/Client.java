package Structural_Pattern.bridge;

/**
 * 桥接模式
 * 将抽象与实现分离开来，使它们可以独立变化。
 * Abstraction：定义抽象类的接口
 * Implementor：定义实现类接口
 *
 * RemoteControl 表示遥控器，指代 Abstraction。
 * TV 表示电视，指代 Implementor。
 * 桥接模式将遥控器和电视分离开来，从而可以独立改变遥控器或者电视的实现。
 */
public class Client {
    public static void main(String[] args) {
        RemoteControl remoteControl1 = new ConcreteRemoteControl1(new RCA());
        remoteControl1.on();
        remoteControl1.off();
        remoteControl1.tuneChannel();
        RemoteControl remoteControl2 = new ConcreteRemoteControl2(new Sony());
        remoteControl2.on();
        remoteControl2.off();
        remoteControl2.tuneChannel();
    }
}

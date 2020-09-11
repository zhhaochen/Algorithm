package Behavioral_Pattern.observer;

/**
 * 观察者模式
 * 定义对象之间的*一对多*依赖，当一个对象状态改变时，它的所有依赖都会收到通知并且自动更新状态。
 * 主题（Subject）是被观察的对象，而其所有依赖者（Observer）称为观察者。
 */
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();
}

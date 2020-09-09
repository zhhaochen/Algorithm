package Creational_Pattern.factory_method;

import Creational_Pattern.simple_factory.Product;

/**
 * 工厂方法
 * 由子类决定要实例化哪个类。工厂方法把实例化操作推迟到子类。
 */

public abstract class Factory {

    abstract public Product factoryMethod();

    // 这个方法需要用到一个产品对象，这个产品对象由 factoryMethod() 方法创建。该方法是抽象的，需要由子类去实现。
    public void doSomething() {
        // 注意这里是产品
        Product product = factoryMethod();
        // do something with the product
    }
}

package Creational_Pattern.factory_method;

import Creational_Pattern.simple_factory.ConcreteProduct2;
import Creational_Pattern.simple_factory.Product;

public class ConcreteFactory2 extends Factory{
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}

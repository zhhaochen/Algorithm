package Creational_Pattern.factory_method;

import Creational_Pattern.simple_factory.ConcreteProduct1;
import Creational_Pattern.simple_factory.Product;

public class ConcreteFactory1 extends Factory{
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}

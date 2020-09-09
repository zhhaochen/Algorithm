package Creational_Pattern.factory_method;

import Creational_Pattern.simple_factory.ConcreteProduct;
import Creational_Pattern.simple_factory.Product;

public class ConcreteFactory extends Factory{
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}

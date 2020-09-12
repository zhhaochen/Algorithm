package Structural_Pattern.decorator;

/**
 * 装饰模式
 * 为对象动态添加功能。
 * 装饰者（Decorator）和具体组件（ConcreteComponent）都继承自组件（Component）
 * 设计不同种类的饮料，饮料可以添加配料，比如可以添加牛奶，并且支持动态添加新配料。
 * 每增加一种配料，该饮料的价格就会增加，要求计算一种饮料的价格。
 *
 * 设计原则
 * 类应该对扩展开放，对修改关闭：也就是添加新功能时不需要修改代码。饮料可以动态添加新的配料，而不需要去修改饮料的代码。
 */
public class Client {
    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        beverage = new Mocha(beverage);
        beverage = new Milk(beverage);
        System.out.println(beverage.cost());
    }
}

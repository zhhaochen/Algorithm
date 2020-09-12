package Behavioral_Pattern.visitor;

/**
 * 为一个对象结构（比如组合结构）增加新能力。
 * Visitor：访问者，为每一个 ConcreteElement 声明一个 visit 操作
 * ConcreteVisitor：具体访问者，存储遍历过程中的累计结果
 * ObjectStructure：对象结构，可以是组合结构，或者是一个集合。
 */
public interface Visitor {
    void visit(Customer customer);

    void visit(Order order);

    void visit(Item item);
}

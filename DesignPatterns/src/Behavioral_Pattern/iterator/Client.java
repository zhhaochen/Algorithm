package Behavioral_Pattern.iterator;

public class Client {
    public static void main(String[] args) {
        // 一个具体的聚合类
        Aggregate aggregate = new ConcreteAggregate();

        //从聚合对象获取一个迭代器，使用迭代器可以顺序获取聚合类的元素
        Iterator<Integer> iterator = aggregate.createIterator();

        // 使用迭代器遍历
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

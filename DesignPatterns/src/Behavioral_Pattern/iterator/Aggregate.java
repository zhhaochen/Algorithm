package Behavioral_Pattern.iterator;

/**
 * 迭代器模式
 * 提供一种顺序访问聚合对象元素的方法，并且不暴露聚合对象的内部表示。
 */
public interface Aggregate {
    Iterator createIterator();
}

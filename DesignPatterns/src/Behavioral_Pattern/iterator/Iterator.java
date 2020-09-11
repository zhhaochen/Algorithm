package Behavioral_Pattern.iterator;

public interface Iterator<Item> {

    // 泛型

    Item next();

    boolean hasNext();

}

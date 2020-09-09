package Creational_Pattern.builder;

import java.util.Arrays;

/**
 * 生成器模式
 * 封装一个对象的构造过程，并允许按步骤构造。
 *
 * 比如要画多个小人，高矮胖瘦，画的步骤是一样的只是参数不一样
 * 可以抽象出画小人的过程为一个抽象类，所需的参数用抽象方法获取
 * 比如要画一个瘦的小人，必须继承这个类，重写这些方法
 * 然后根据这些参数画出小人来，不会因为忘记某些参数导致缺胳膊少腿
 */
public class AbstractStringBuilder {
    protected char[] value;

    protected int count;

    public AbstractStringBuilder(int capacity) {
        count = 0;
        value = new char[capacity];
    }

    public AbstractStringBuilder append(char c) {
        ensureCapacityInternal(count + 1);
        value[count++] = c;
        return this;
    }

    private void ensureCapacityInternal(int minimumCapacity) {
        // overflow-conscious code
        if (minimumCapacity - value.length > 0){
            expandCapacity(minimumCapacity);
        }
    }

    void expandCapacity(int minimumCapacity) {
        int newCapacity = value.length * 2 + 2;
        if (newCapacity - minimumCapacity < 0){
            newCapacity = minimumCapacity;
        }
        if (newCapacity < 0) {
            if (minimumCapacity < 0) {
                // overflow
                throw new OutOfMemoryError();
            }
            newCapacity = Integer.MAX_VALUE;
        }
        value = Arrays.copyOf(value, newCapacity);
    }
}

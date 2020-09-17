package Top100;

import java.util.PriorityQueue;

/**
 * 2020.09.17
 * 设计一种数据结构，可以存储数据，并且随时获取已存储数据的中位数
 */
public class Find_Median_from_Data_Stream {
    PriorityQueue<Integer> small = null;
    PriorityQueue<Integer> large = null;

    /** initialize your data structure here. */
    public Find_Median_from_Data_Stream() {
        // 存储较小的数，用大顶堆
        small = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
        // 存储较大的数，用小顶堆
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 中位数从small里
        if (small.size() >= large.size()){
            // 假如small里有2，large有1，small先放入成3，再放入large，small2 large2
            // 加入small里有2，large有2，small先放入成3，在放入large，small2 large3
            small.add(num);
            large.add(small.poll());
        }else {
            large.add(num);
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.isEmpty() && large.isEmpty()){
            return 0;
        }else {
            if (small.size() == large.size()){
                return (small.peek() + large.peek()) / 2.0;
            }else {
                return large.peek();
            }
        }
    }
}

package JianZhiOffer;

import java.util.PriorityQueue;

public class Solution41 {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    /** initialize your data structure here. */
    public Solution41() {
        small = new PriorityQueue<>((o1, o2) -> {return o2 - o1;}); // 存储较小部分的，用大顶堆
        large = new PriorityQueue<>(); // 存储较大部分，用小顶堆
    }

    public void addNum(int num) {
        // 相等时，加到 large 里
        if (small.size() == large.size()){
            small.offer(num);
            large.offer(small.poll());
        }else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.isEmpty() && large.isEmpty()) return 0;
        else if (small.size() == large.size()) return (small.peek() + large.peek()) / 2.0;
        else return large.peek();
    }
}

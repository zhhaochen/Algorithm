package JianZhi_Offer;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 */
public class Solution63 {

    PriorityQueue<Integer> small = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
    PriorityQueue<Integer> large = new PriorityQueue<>();

    public void Insert(Integer num) {
        if(small.size() >= large.size()){
            small.add(num);
            large.add(small.poll());
        }else{
            large.add(num);
            small.add(large.poll());
        }
    }

    public Double GetMedian() {
        if(large.size() > small.size()){
            return Double.valueOf(large.peek());
        }else{
            return (small.peek() + large.peek()) / 2.0;
        }
    }

}

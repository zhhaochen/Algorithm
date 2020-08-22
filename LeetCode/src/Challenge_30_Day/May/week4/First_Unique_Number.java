package Challenge_30_Day.May.week4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class First_Unique_Number {
    public static void main(String[] args) {
        FirstUnique unique = new FirstUnique(new int[]{1, 1, 5, 3, 2});
        unique.add(2);
        unique.add(4);
        System.out.println(unique.showFirstUnique());
    }

}
class FirstUnique{
    //注意map的存储并不是按照顺序来的，所以需要一个队列进行存储
    private Map<Integer, Integer> map = new HashMap<>();
    private Queue<Integer> queue = new LinkedList<Integer>();
    public FirstUnique(int[] nums) {
        for (int num : nums) {
            if (map.get(num) == null){
                map.put(num, 1);
                queue.add(num);
            }else {
                int count = map.get(num);
                map.put(num, count+1);
            }
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty()){
            int top = queue.peek();
            if (map.get(top) == 1){
                return top;
            }else {
                queue.poll();
            }
        }
        return  -1;
    }

    public void add(int value) {
        if (map.get(value) == null){
            queue.add(value);
            map.put(value, 1);
        }else {
            int count = map.get(value);
            map.put(value, count+1);
        }
    }
}
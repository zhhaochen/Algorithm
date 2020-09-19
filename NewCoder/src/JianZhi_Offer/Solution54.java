package JianZhi_Offer;

import java.util.*;

/**
 * 实现一个函数用来找出字符流中第一个只出现一次的字符。
 */
public class Solution54 {
    private Queue<Character> queue = new LinkedList<>();
    private Map<Character, Integer> map = new HashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch){
        if (!map.containsKey(ch)){
            queue.add(ch);
            map.put(ch, 1);
        }else {
            int count = map.get(ch);
            map.put(ch, count + 1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        while (!queue.isEmpty()){
            if (map.get(queue.peek()) == 1){
                return queue.peek();
            }else {
                queue.poll();
            }
        }
        return '#';
    }
}

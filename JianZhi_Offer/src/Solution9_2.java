import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现栈
 */
public class Solution9_2 {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    public void push(int node){
        queue1.offer(node);
    }

    public int pop(){
        //插入时先往队列1里插，所以先判断它
        if (!queue1.isEmpty()){
            while (queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }else {
            while (queue2.size()>2){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }
}

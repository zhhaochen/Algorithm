import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution59_II {

    Queue<Integer> queue;
    Deque<Integer> max;
    public Solution59_II() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if (!max.isEmpty()) return max.peekFirst();
        return -1;
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!max.isEmpty() && value > max.peekLast()) max.pollLast();
        max.offer(value);
    }

    public int pop_front() {
        if (!queue.isEmpty()){
            int tmp = queue.poll();
            if (tmp == max.peekFirst()) max.pollFirst();
            return tmp;
        }
        return -1;
    }
}

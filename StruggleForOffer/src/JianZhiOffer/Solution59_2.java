package JianZhiOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution59_2 {
    Deque<Integer> deque;
    Queue<Integer> queue;
    public Solution59_2() {
        deque = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.getFirst();
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && deque.getLast() < value) deque.pollLast();
        deque.offer(value);
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int res = queue.poll();
        if (!deque.isEmpty() && deque.getFirst() == res) deque.poll();
        return res;
    }
}

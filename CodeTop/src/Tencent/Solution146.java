package Tencent;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {
    class LinkedNode{
        int key;
        int val;
        LinkedNode pre;
        LinkedNode next;
        LinkedNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private int capacity, size;
    private LinkedNode head, tail;
    Map<Integer, LinkedNode> map;
    public Solution146(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode(0, 0);
        tail = new LinkedNode(0, 0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
        size = 0;
    }

    public int get(int key) {
        LinkedNode node = map.get(key);
        if (node != null){
            removeNode(node);
            addHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        LinkedNode node = map.get(key);
        if (node != null){
            node.val = value;
            removeNode(node);
            addHead(node);
        }else {
            if (size == capacity){
                map.remove(tail.pre.key);
                // 删除最小的
                removeNode(tail.pre);
                size--;
            }
            node = new LinkedNode(key, value);
            addHead(node);
            size++;
            map.put(key, node);
        }
    }

    public void removeNode(LinkedNode node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void addHead(LinkedNode node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }
}

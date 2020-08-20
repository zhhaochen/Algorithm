package queue;

public class TestMyQueue {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.addElement(9);
        queue.addElement(8);
        queue.addElement(7);
        System.out.println(queue.pollElement());
        queue.addElement(6);
        System.out.println(queue.pollElement());
    }
}

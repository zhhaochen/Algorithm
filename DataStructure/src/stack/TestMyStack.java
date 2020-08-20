package stack;

public class TestMyStack {

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.pushElement(9);
        stack.pushElement(8);
        stack.pushElement(7);
        System.out.println(stack.popElement());
        System.out.println(stack.peekElement());
        System.out.println(stack.popElement());
        System.out.println(stack.popElement());
    }
}

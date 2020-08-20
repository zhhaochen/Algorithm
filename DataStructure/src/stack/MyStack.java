package stack;

public class MyStack {

    private int[] elements;

    public MyStack(){
        elements = new int[0];
    }

    public void pushElement(int element){
        int[] newArra = new int[elements.length+1];
        for (int i=0; i<elements.length; i++){
            newArra[i] = elements[i];
        }
        newArra[elements.length] = element;
        elements = newArra;
    }

    public int popElement(){
        if (elements.length==0){
            throw new RuntimeException("stack is null");
        }
        int element = elements[elements.length-1];
        int[] newArra = new int[elements.length-1];
        for (int i=0; i<newArra.length; i++){
            newArra[i] = elements[i];
        }
        elements = newArra;
        return element;
    }

    public int peekElement(){
        if (elements.length==0){
            throw new RuntimeException("stack is null");
        }
        return elements[elements.length-1];
    }

    public boolean isEmpty(){
        return elements.length == 0;
    }

}

package queue;

public class MyQueue {

    private int[] elements;

    public MyQueue(){
        elements = new int[0];
    }

    public void addElement(int element){
        int[] newArra = new int[elements.length+1];
        for (int i=0; i<elements.length; i++){
            newArra[i] = elements[i];
        }
        newArra[elements.length] = element;
        elements = newArra;
    }

    public int pollElement(){
        if (elements.length==0){
            throw new RuntimeException("stack is null");
        }
        int element = elements[0];
        int[] newArra = new int[elements.length-1];
        for (int i=0; i<newArra.length; i++){
            newArra[i] = elements[i+1];
        }
        elements = newArra;
        return element;
    }

    public boolean isEmpyt(){
        return elements.length == 0;
    }
}

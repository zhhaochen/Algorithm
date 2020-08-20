package array;

import java.util.Arrays;

public class MyArray {

    private int[] elements;

    public MyArray(){
        elements = new int[0];
    }

    public MyArray(int len){
        elements = new int[len];
        for (int i = 0; i<len; i++){
            elements[i] = i;
        }
    }

    public int getSize(){
        return elements.length;
    }

    public int getElement(int index){
        if (index < elements.length)
            return elements[index];
        else
            return -1;
    }

    public void insertElement(int element){
        int[] newArra = new int[elements.length+1];
        for (int i=0; i<elements.length; i++){
            newArra[i] = elements[i];
        }
        newArra[elements.length] = element;
        elements = newArra;
    }

    public void insertElement(int element, int index){
        int newArr[] = new int[elements.length+1];
        if (index<0 || index>elements.length+1){
            throw  new RuntimeException("index 越界");
        }
        for (int j = 0; j<elements.length; j++){
            if (j<index){
                newArr[j] = elements[j];
            }else {
                newArr[j+1] = elements[j];
            }
        }
        newArr[index] = element;
        elements = newArr;
    }

    public void delElement(int index){
        if (index<0 || index>elements.length-1){
            throw  new RuntimeException("index 越界");
        }
        int[] newArr = new int[elements.length-1];
        for (int j = 0; j<newArr.length; j++){
            if (j<index){
                newArr[j] = elements[j];
            }else {
                newArr[j] = elements[j+1];
            }
        }
        elements = newArr;
    }

    public void showArray(){
        System.out.println(Arrays.toString(elements));
    }

}

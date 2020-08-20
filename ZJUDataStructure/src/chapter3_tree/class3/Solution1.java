package chapter3_tree.class3;

import java.util.Arrays;

/**
 * 堆 heap的相关操作
 */
public class Solution1 {
}

class Heap{
    int[] elements;
    int maxSize;
    int size = 0;
    public Heap(int maxSize){
        this.maxSize = maxSize;
        elements = new int[maxSize+1]; //存储的索引从1开始，0作为哨兵位置
        elements[0] = 10000; //用一个很大的数作为哨兵
    }

    public void insert(int element){
        if (!isFull()){ //堆没有满时
            int i = ++size;
            //通过不断比较和交换父节点，找到合适位置
            for (; elements[i/2]<element; i/=2){
                elements[i] = elements[i/2];
            }
            elements[i] = element;
        }
    }
    public int delete(){
        if (isEmpty()){
            System.out.println("堆为空");
            return -10000;
        }
        int maxItem = elements[1]; //取出最大的结点
        int temp = elements[size--]; //将最后一个结点移到第一个结点，然后一层层向下比较
        int parent = 1, child; //初始索引指向第一个结点
        for (; parent*2<=size;parent=child){ // <=是为了判断是否有孩子结点
            child = parent*2;
            if (child!=size && elements[child]<elements[child+1]){ //判断是否有右孩子
                child++;
            }
            if (temp>elements[child]){ //判断较大的孩子结点与最后一个结点谁大，此时temp相当于父节点的值，为了比较交换
                break;
            }else {
                elements[parent] = elements[child]; //如果还是孩子大，就交换
            }
        }
        elements[parent] = temp; //最后得到的位置就是temp可以插入的位置
        return maxItem;
    }

    public void buildHeap(int[] data)
    { /* 调整存储中的元素，使满足最大堆的有序性  */
        /* 所有的堆元素先按照输入顺序存入到数组中 */
        input(data);

        int i;
        /* 从最后一个结点的父节点开始，到根结点1 */
        for( i = size/2; i>0; i-- ){
            /* 下滤：将H中以elements[i]为根的子堆调整为最大堆 */
            int parent, child;

            int x =elements[i]; /* 取出根结点存放的值 */
            for( parent=i; parent*2<=size; parent=child ) {
                child = parent * 2;
                if((child!=size) && (elements[child]<elements[child+1])){
                    child++;  /* Child指向左右子结点的较大者 */
                }
                if( x >= elements[child] ) {
                    break; /* 找到了合适位置 */
                }
                else{
                    /* 下滤X */
                    elements[parent] =elements[child];
                }
            }
            elements[parent] = x;
        }
    }
    public void show(){
        System.out.println(Arrays.toString(elements));
    }
    private boolean isFull(){
        return size==maxSize;
    }
    private boolean isEmpty(){
        return size==0;
    }
    private void input(int[] data){
        maxSize = data.length;
        elements = new int[maxSize+1];
        size = 0;
        for (int i=1; i<=data.length; i++){
            elements[i] = data[i-1];
            size++;
        }
    }
}

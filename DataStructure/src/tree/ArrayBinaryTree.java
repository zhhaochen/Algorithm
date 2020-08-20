package tree;


//顺序二叉树
public class ArrayBinaryTree {
    int[] data;

    public ArrayBinaryTree(int[] data){
        this.data = data;
    }

    //前序遍历
    public void frontShow(){
        frontShow(0);
    }
    private void frontShow(int index){
        if (data == null || data.length==0){
            return;
        }
        //当前节点
        System.out.print(data[index]+" ");
        //左子树
        if (2*index+1<data.length){
            frontShow(2*index+1);
        }
        if (2*index+2<data.length){
            frontShow(2*index+2);
        }
    }
}

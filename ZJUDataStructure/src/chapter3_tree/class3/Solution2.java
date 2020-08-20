package chapter3_tree.class3;

/**
 * 哈夫曼树，用最小堆实现
 */
public class Solution2 {

    //O(nlogn)
    TreeNode huffman(Heap minHeap){ //输入为一个最小堆，假设已经按照结点的权值排好序，每个元素都是一个结点，此处暂时用数值代替结点
        int i;  TreeNode T;
        //BuildMinHeap(H); /*将H->Elements[]按权值调整为最小堆*/
        for (i = 1; i < minHeap.size; i++) { /*做H->Size-1次合并*/
            T = new TreeNode(); /*建立新结点*/
            T.left = new TreeNode(minHeap.delete());  /*从最小堆中删除一个结点，作为新T的左子结点，此处暂时代替*/
            T.right = new TreeNode(minHeap.delete());  /*从最小堆中删除一个结点，作为新T的右子结点，此处暂时代替*/
            T.weight = T.left.weight+T.right.weight;                     /*计算新权值*/
            minHeap.insert(T.weight); /*将新结点插入最小堆，应该插入结点，但是这里只是代替，所以用了权值*/
        }
        T = new TreeNode(minHeap.delete()); //当所有结束后，堆中只有一个结点，就是建好的哈夫曼树，此时返回这个结点，此处只是代替
        return T; //得到的就是哈夫曼树的结点
    }
}

class TreeNode{
    int weight;
    TreeNode left;
    TreeNode right;
    public TreeNode(){

    }

    public TreeNode(int weight){
        this.weight = weight;
    }
}

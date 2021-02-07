package Sort;

/**
 * 堆排序，是一个完全二叉树，每个节点的值都大于等于(小于等于)孩子节点的值
 * a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
 * b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 * c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
 * O(nlogn) O(n)
 */
public class HeapSort {


    public void heapSort(int[] arr){
        // 构建大顶堆
        for(int i = arr.length / 2 - 1; i >= 0; i--){
            // 从第一个非叶子节点从下至上，从左到右调整结构
            adjustHeap(arr, i, arr.length);
        }
        // 调整堆结构 + 交换堆顶元素与末尾元素，把当前最大的放到末尾，找下一个最大的，这一步为了排序
        for (int j = arr.length - 1; j > 0; j--){
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }

    // 调整大顶堆，对当前节点，因为自下而上，可认为左右节点都是大顶堆
    public void adjustHeap(int[] arr, int i, int length){
        // 取出当前元素
        int tmp = arr[i];
        // 从 i节点的左节点开始，即 2*i+1节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1){
            // 如果左子节点小于右子节点，k指向右子节点，选一个较大的大顶堆
            if(k + 1 < length && arr[k] < arr[k + 1]) k++;
            if (arr[k] > tmp){
                // 如果子节点大于父节点，讲子节点的值赋给父节点，不用交换
                arr[i] = arr[k];
                i = k;
            }else break;
        }
        // tmp值放回最终位置
        arr[i] = tmp;
    }

    public void swap(int[] arr, int i, int j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

}

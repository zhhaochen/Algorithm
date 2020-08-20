import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序
 * 时间复杂度 最好每次平分O(nlogn) 最差O(n^2)退化为冒泡排序 平均O(nlogn)
 * 空间复杂度 最好每次平分O(logn) 最差O(n)退化为冒泡排序
 */
public class Solution11_1 {
    public static void main(String[] args) {
        int[] data = new int[]{5, 4, 7, 2, 1, 6, 3, 0, 5, 12, 3, 9};
//        QuickSort1_2(data, 0, data.length-1);
//        QuickSort2(data);
//        BubbleSort(data);
//        InsertSort(data);
//        SelectSort(data);
        ShellSort(data);
        int $a = 10;
        System.out.println(Arrays.toString(data));
    }

    //1_1、快速排序，在数组中选定一个数字，比它小的移到左边，大的移到右边，递归进行
    public static void QuickSort1_1(int[] data){
        if (data!=null || data.length!=0){
            QuickSort1_1(data, 0, data.length-1);
        }
    }
    public static void QuickSort1_1(int[] data, int start, int end){
        int index = start;
        //交换的写法过于复杂
        for (int i=index + 1; i<=end; i++){
            if (data[i] < data[index]){
                int tmp = data[i];
                for (int j = i; j>index; j--){ //注意此处的交换
                    data[j] = data[j-1];
                }
                data[index]=tmp;
                index++; //注意此处的索引增加
            }
        }
        if (index!=start+1 && index!=start){ //注意此处考虑两个条件，主要是第二个
            QuickSort1_1(data, start, index-1);
        }
        if (index!=end-1 && index!=end){
            QuickSort1_1(data, index+1, end);
        }
    }
    //1_2、快速排序另一种递归写法
    public static void QuickSort1_2(int[] data, int start, int end){
        int standard = data[start];
        int low = start;
        int high = end;
        while (low < high){
            while (low<high && data[high] >= standard){
                high--;
            }
            data[low] = data[high];
            while (low<high && data[low] < standard){
                low++;
            }
            data[high] = data[low];
        }
        data[low] = standard;
        if (low > start) {
            QuickSort1_2(data, start, low);
        }
        if (low < end) {
            QuickSort1_2(data, low+1, end);
        }
    }
    //1_2、快速排序非递归写法 --------------- 重点！！！
    public static void QuickSort2(int[] data){
        Stack<Integer> indexStack = new Stack<>(); //使用栈来记录索引位置，队列也可以，一个原理，就是需要辅助空间来记录索引
        indexStack.push(0);
        indexStack.push(data.length-1);
        while (!indexStack.isEmpty()){
            int end = indexStack.pop();
            int start = indexStack.pop();
            int low = start;
            int high = end;
            int standard = data[low];
            while (low<high){
                while (low<high && data[high] >= standard){
                    high--;
                }
                data[low] = data[high];
                while (low<high && data[low] < standard){
                    low++;
                }
                data[high] = data[low];
            }
            data[low] = standard;
            if (low > start){
                indexStack.push(start);
                indexStack.push(low);
            }
            if (low < end){
                indexStack.push(low+1);
                indexStack.push(end);
            }
        }
    }
    //---------------------------------------------------------------------------
    //冒泡排序，两两比较，大的后移
    public static void BubbleSort(int[] data){
        for (int i = data.length; i>0; i--){
            for (int j=0; j<i - 1; j++){
                if (data[j] > data[j+1]){
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
    }
    //---------------------------------------------------------------------------
    //插入排序 对每一个进行检测，如果比前一个小，则向前进行排序
    public static void InsertSort(int[] data){
        for (int i = 1; i<data.length; i++){
            if (data[i] < data[i-1]){
                int tmp = data[i];
                int j = i;
                for (; j>0; j--){
                    if (data[j-1] < tmp){
                        break;
                    }
                    data[j] = data[j-1];
                }
                data[j] = tmp;
            }
        }
    }
    //---------------------------------------------------------------------------
    //选择排序 每一次排序选择一个最小的交换到最前面排序好的末尾
    public static void SelectSort(int[] data){
        for (int i=0; i<data.length-1;i++){
            int index = i;
            //找出最小的
            for (int j=i+1; j<data.length; j++){
                if (data[j] < data[i]) {
                    index=j;
                }
            }
            int tmp = data[i];
            data[i] = data[index];
            data[index] = tmp;
        }
    }
    //---------------------------------------------------------------------------
    //希尔排序 进行多次划分间隔，依据间隔进行插入排序，思想是有序数组的插入排序十分简单
    public static void ShellSort(int[] data){
        int len = data.length;
        int gap = len/2;
        while (gap > 0){
            //根据gap划分间隔
            for (int i=0; i<gap; i++){
                // 对每个间隔进行插入排序
                for (int j = i+gap; j<len; j = j+gap){
                    if (data[j]<data[j-gap]){
                        int tmp = data[j];
                        int index = j;
                        for (; index>=i+gap; index=index-gap){
                            if (data[index-gap]<tmp){
                                break;
                            }
                            data[index]= data[index-gap];
                        }
                        data[index] = tmp;
                    }
                }
            }
            gap /= 2;
        }
    }
}

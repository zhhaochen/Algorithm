package Challenge_30_Day.week2;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 * <p>
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 * 每次挑俩最大的大减小，得0不放回，大于0放回
 */
public class Last_Stone_Weight {
    public static void main(String[] args) {
        int[] stones = new int[]{9, 3, 2, 10};
        System.out.println(lastStoneWeight(stones));
    }

    //思路：用最大堆进行
    public static int lastStoneWeight(int[] stones) {
        int[] heap = new int[stones.length + 1]; //首先建一个堆
        heap[0] = Integer.MAX_VALUE; //哨兵
        int size = 0; //记录堆的大小
        int len = stones.length;
        //1、将所有的数据放入堆中
        for (int i = 0; i < len; i++) {
            int item = stones[i];
            insert(heap, item, ++size);
        }
        //2、两两取出最大值并返回，只要里面还有两个以上的值
        while (size > 1) {
            //取值，顺便缩小范围
            int x = delete(heap, size--);
            int y = delete(heap, size--);
            if (x != y) {
                int item = x - y > 0 ? x - y : y - x;
                insert(heap, item, ++size);
            }
        }
        return size > 0 ? heap[1] : 0;
    }

    //将新值插入
    private static void insert(int[] heap, int item, int posi) {
        for (; heap[posi / 2] < item; posi /= 2) {
            heap[posi] = heap[posi / 2];
        }
        heap[posi] = item;
    }

    //假设size传入的值是原始的还没有size--
    private static int delete(int[] heap, int size) {
        int result = heap[1];
        int tmp = heap[size--];
        int parent = 1;
        int child = 1;
        for (; parent * 2 <= size; parent = child) {
            child = parent * 2;
            //先选出两个子孩子较大的那一个
            if (child != size && heap[child] < heap[child + 1]) {
                child++;
            }
            if (tmp >= heap[child]) {
                break;
            } else {
                heap[parent] = heap[child];
            }
        }
        heap[parent] = tmp;
        return result;
    }
}

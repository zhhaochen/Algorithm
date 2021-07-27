package Microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1442 {
    public int countTriplets(int[] arr) {
        int len = arr.length;
        int[] xor = new int[len + 1];
        // 前缀异或，则 arr[i,...,j]的异或结果为 xor[j + 1] ^ xor[i]
        for (int i = 1; i <= len; i++) xor[i] = xor[i - 1] ^ arr[i - 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int res = 0;
        for (int k = 0; k <= len; k++){
            List<Integer> index = map.getOrDefault(xor[k], new ArrayList<>());
            // 与当前异或值相同的下标
            for (int idx : index){
                int i = idx + 1; // 这里只是为了映射到xor数组
                res += k - i; // 注意这里，arr[i,...,k - 1] = 0，则个数应该是 k - 1 - i
            }
            index.add(k);
            map.put(xor[k], index);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 7};
        new Solution1442().countTriplets(arr);
    }
}

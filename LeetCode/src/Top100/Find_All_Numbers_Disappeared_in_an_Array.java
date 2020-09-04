package Top100;

import java.util.LinkedList;
import java.util.List;

public class Find_All_Numbers_Disappeared_in_an_Array {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List res = findDisappearedNumbers(nums);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        int cnt = 0;
        while (cnt < len) {
            if (nums[cnt] != cnt + 1 && nums[nums[cnt] - 1] != nums[cnt]) {
                int tmp = nums[cnt];
                nums[cnt] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            } else {
                cnt++;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
}

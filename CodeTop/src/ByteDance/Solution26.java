package ByteDance;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == nums[left]){
                if (i == left) nums[index++] = nums[left];
            }else {
                left = i;
                i--;
            }
        }
        return index;
    }
    public int removeDuplicates2(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i-1]) nums[index++] = nums[i];
        }
        return index;
    }
}

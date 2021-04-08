package Microsoft;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        int index = 0;
        while (right < nums.length){
            if (nums[right] == nums[left]){
                if (right - left < 2) nums[index++] = nums[left];
                right++;
            }else {
                left = right;
            }
        }
        return index;
    }
}

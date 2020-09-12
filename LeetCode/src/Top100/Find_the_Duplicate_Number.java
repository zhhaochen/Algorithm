package Top100;

/**
 * 2020.09.12
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one duplicate number in nums, return this duplicate number.
 */
public class Find_the_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i+1){
                int tmp = nums[i];
                if(tmp == nums[tmp-1]){
                    return tmp;
                }else{
                    nums[i] = nums[tmp-1];
                    nums[tmp-1] = tmp;
                }
            }else{
                i++;
            }
        }
        return 0;
    }
}

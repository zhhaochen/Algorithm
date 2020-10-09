package Top100;

/**
 * 2020.10.9
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Could you solve this problem without using the library's sort function?
 * Could you come up with a one-pass algorithm using only O(1) constant space?
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 */
public class Sort_Colors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1){
            return;
        }
        int red_0 = 0;
        int blue_2 = nums.length-1;
        for (int i = 0; i <= blue_2; i++){
            if (nums[i] == 0){
                nums[i] = nums[red_0];
                nums[red_0++] = 0;
            }else if (nums[i] == 2){
                /**
                 * 蓝色2交换完毕之后，需要i--， 停留 i 在原地一次，因为还需要继续检查 被2交换回来的数字。
                 * 那当遇到红色0，交换完毕不需要停留i 的原因是， 交换回来的只可能是1，对于1，我们不需要做任何处理，直接过就可以。
                 */
                nums[i--] = nums[blue_2];
                nums[blue_2--] = 2;
            }
        }
    }
}

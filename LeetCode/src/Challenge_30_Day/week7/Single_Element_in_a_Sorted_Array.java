package Challenge_30_Day.week7;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once. Find this single element that appears only once.
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 */
public class Single_Element_in_a_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1};
        System.out.println(singleNonDuplicate(nums));
    }
    public static int singleNonDuplicate(int[] nums) {
        //长度一定是奇数
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            if (nums[mid] == nums[mid+1]){
                if ((right - mid + 1) % 2 == 0){
                    right = mid - 1;
                }else {
                    left = mid;
                }
            }else {
                if ((mid - left + 1) % 2 == 0){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
        }
        return nums[left];
    }
}

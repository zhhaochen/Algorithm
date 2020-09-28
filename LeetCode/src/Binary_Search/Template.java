package Binary_Search;

/**
 * 二分查找模板
 * 1、基本查找
 * 2、查找左边界
 * 3、查找右边界
 */
public class Template {
    // 基本查找
    int binary_search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }
    // 查找左边界
    int left_bound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                // 不返回，锁定左侧边界
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }
    // 查找右边界
    int right_bound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                // 不返回，锁定右侧边界
                left = mid + 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        //
        if (right < 0 || nums[right] != target){
            return -1;
        }
        return right;
    }
}

package JianZhi_Offer;

import java.util.Arrays;

/**
 * 大小王为0，可以替代任何牌
 * A-K 表示1-13
 * 能否组成顺子
 */
public class Solution45 {
    public boolean isContinuous(int [] numbers) {
        int len = numbers.length;
        if(len < 1){ //空牌
            return false;
        }
        Arrays.sort(numbers); //排序
        int index = 0;
        int number = 0;
        while (index < 4 && index<len){ //四张大小王
            if (numbers[index++] == 0){
                number++;
            }else {
                break;
            }
        }
        int cur = numbers[number]; //起始牌
        for (int i=number; i<numbers.length;){
            if (numbers[i] == cur){
                i++;
                cur++;
            }else {
                if (number < 1){
                    return false;
                }else {
                    number--;
                    cur++;
                }
            }
        }
        return true;
    }

    //TODO 好方法
    public boolean isContinuous2(int[] nums) {

        if (nums.length < 5) //少于五张就不是
            return false;

        Arrays.sort(nums); //排序

        // 统计癞子数量
        int cnt = 0;
        for (int num : nums)
            if (num == 0)
                cnt++;

        // 使用癞子去补全不连续的顺子
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) //有重复的不是
                return false;
            cnt -= nums[i + 1] - nums[i] - 1; //如果相差1就不用减去
        }

        return cnt >= 0; //看最后剩的王的数量
    }
}

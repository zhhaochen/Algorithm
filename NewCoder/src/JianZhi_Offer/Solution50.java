package JianZhi_Offer;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Solution50 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean res = false;
        int index = 0;
        while (index < length){
            if (numbers[index] != index){
                if (numbers[numbers[index]] == numbers[index]){
                    res = true;
                    break;
                }else {
                    int tmp = numbers[numbers[index]];
                    numbers[numbers[index]] = numbers[index];
                    numbers[index] = tmp;
                }
            }else {
                index++;
            }
        }
        if (res) {
            duplication[0] = numbers[index];
        }
        return res;
    }
}

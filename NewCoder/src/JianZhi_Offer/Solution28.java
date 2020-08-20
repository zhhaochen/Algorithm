package JianZhi_Offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class Solution28 {
    //因为如果一个数出现超过了一半次数，则一定是最后使得cnt=1的值
    //但是因为可能不存在，所以需要最后进行一个验证
    public int MoreThanHalfNum_Solution(int [] array) {
        int cur = array[0];
        int cnt = 1;
        for(int i=1; i<array.length; i++){
            if(array[i] == cur){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt == 0){
                cur = array[i];
                cnt = 1;
            }
        }
        cnt = 0;
        for(int num: array){
            if(num == cur){
                cnt++;
            }
        }
        return cnt>array.length/2?cur:0;
    }
}

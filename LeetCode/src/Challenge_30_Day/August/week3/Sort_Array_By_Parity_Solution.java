package Challenge_30_Day.August.week3;

/**
 * 2020.08.22
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class Sort_Array_By_Parity_Solution {
    // 思路是一趟快速排序
    public int[] sortArrayByParity(int[] A) {
        if (A.length == 0){
            return A;
        }
        int i = 0;
        int j = A.length -1;
        while(i<j){
            if(A[i] % 2 == 0){
                i++;
            }
            if(A[j] % 2 != 0){
                j--;
            }
            if(i<j){
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}

package JianZhi_Offer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Solution51 {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        int left = 1;
        for (int i = 0; i < len; i++) {
            B[i] = left;
            left *= A[i];
        }
        int right = 1;
        for (int i = len-1; i>=0; i--){
            B[i] *= right;
            right *= A[i];
        }
        return B;
    }
}

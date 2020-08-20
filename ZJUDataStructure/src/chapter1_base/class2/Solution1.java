package chapter1_base.class2;

/**
 * 最大子列和问题
 * 给定K个整数组成的序列{ N1, N2, ..., NK}，
 * “连续子列”被定义为{ Ni, Ni+1, ..., Nj}，其中 1≤i≤j≤K。
 * “最大子列和”则被定义为所有连续子列元素的和中最大者。
 * 例如给定序列{ -2, 11, -4, 13, -5, -2 }，其连续子列{ 11, -4, 13 }有最大的和20。
 * 现要求你编写程序，计算给定整数序列的最大子列和。
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] A = new int[]{-2, 11, -4, 13, -5, -2};
        System.out.println(MaxSubseqSum1(A));
        System.out.println(MaxSubseqSum2(A));
        System.out.println(MaxSubseqSum3(A));
        System.out.println(MaxSubseqSum4(A));
    }

    //1、暴力求解所有子列和 Tn = O(n^3)
    //每一个左右端都要计算和
    static int MaxSubseqSum1(int[] A){
        int n = A.length;
        int MaxSum = 0;
        for (int i=0; i<n; i++){ //i表示子列和左端位置
            for (int j = i; j<n; j++){ //j表示子列和右端位置
                int thisSum = 0;
                for (int k=i; k<=j; k++){
                    thisSum += A[k];
                }
                if (thisSum > MaxSum){
                    MaxSum = thisSum;
                }
            }
        }
        return MaxSum;
    }

    //2、暴力求解所有子列和 二  Tn = O(n^2)
    //固定左端，存储此左端下的前一个右端得值，更新j时直接相加即可
    static int MaxSubseqSum2(int[] A){
        int n = A.length;
        int MaxSum = 0;
        for (int i=0; i<n; i++){ //i表示子列和左端位置
            int thisSum = 0;
            for (int j = i; j<n; j++){ //j表示子列和右端位置
                thisSum += A[j];
                if (thisSum > MaxSum){
                    MaxSum = thisSum;
                }
            }
        }
        return MaxSum;
    }

    //3、分而治之求解 Tn = O(NlogN)
    static int MaxSubseqSum3( int[] A)
    { /* 保持与前2种算法相同的函数接口 */
        int N = A.length;
        return DivideAndConquer( A, 0, N-1 );
    }

    static int Max3( int A, int B, int C )
    { /* 返回3个整数中的最大值 */
        return A > B ? A > C ? A : C : B > C ? B : C;
    }

    static int DivideAndConquer( int List[], int left, int right )
    { /* 分治法求List[left]到List[right]的最大子列和 */
        int MaxLeftSum, MaxRightSum; /* 存放左右子问题的解 */
        int MaxLeftBorderSum, MaxRightBorderSum; /*存放跨分界线的结果*/

        int LeftBorderSum, RightBorderSum;
        int center, i;

        if( left == right )  { /* 递归的终止条件，子列只有1个数字 */
            if( List[left] > 0 ){
                return List[left];
            }
            else {
                return 0;
            }
        }

        /* 下面是"分"的过程 */
        center = ( left + right ) / 2; /* 找到中分点 */
        /* 递归求得两边子列的最大和 */
        MaxLeftSum = DivideAndConquer( List, left, center );
        MaxRightSum = DivideAndConquer( List, center+1, right );

        /* 下面求跨分界线的最大子列和 */
        MaxLeftBorderSum = 0; LeftBorderSum = 0;
        for( i=center; i>=left; i-- ) { /* 从中线向左扫描 */
            LeftBorderSum += List[i];
            if( LeftBorderSum > MaxLeftBorderSum ){
                MaxLeftBorderSum = LeftBorderSum;
            }
        } /* 左边扫描结束 */

        MaxRightBorderSum = 0; RightBorderSum = 0;
        for( i=center+1; i<=right; i++ ) { /* 从中线向右扫描 */
            RightBorderSum += List[i];
            if( RightBorderSum > MaxRightBorderSum ){
                MaxRightBorderSum = RightBorderSum;
            }
        } /* 右边扫描结束 */

        /* 下面返回"治"的结果 */
        return Max3( MaxLeftSum, MaxRightSum, MaxLeftBorderSum + MaxRightBorderSum );
    }

    //4、在线处理解法，如果得到的子列和为负数则抛弃当前得子列和，归零 O(N)
    static int MaxSubseqSum4( int[] A)
    {
        int N = A.length;
        int MaxSum = 0; //返回，万一全是负数？返回就是0了，所以应该取第一个
        int ThisSum = 0; //计算与抛弃
        for (int i = 0; i < N; i++) {
            ThisSum += A[i];
            if (ThisSum > MaxSum){
                MaxSum = ThisSum;
            }else if (ThisSum < 0){ //如果为负则对后面得都是负影响，不如抛弃归零，注意不能用else if，如果全是负数这个无法置零
                ThisSum = 0;
            }
        }
        return MaxSum;
    }
    //这个解法考虑了数组中全是负数的情况，是上一个的改进
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int thisSum = 0;
        int len = nums.length;
        for(int i=0; i<len; i++){
            thisSum += nums[i];
            if(thisSum>maxSum){
                maxSum = thisSum;
            }
            if(thisSum<0){ //如果全是负数，并且是递增的负数，这里单独if而不是else if很有必要
                thisSum = 0;
            }
        }
        return maxSum;
    }
}

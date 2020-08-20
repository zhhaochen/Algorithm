package JianZhi_Offer;

/**
 * 输入一个非空整数数组，判断该数组是不是某<b>二叉搜索树</b>的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution23 {
    public static void main(String[] args) {
        int[] s = new int[]{7, 4, 6, 5};
        VerifySquenceOfBST(s);
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0){
            return false;
        }
        return verify(sequence, 0, sequence.length-1);
    }

    private static boolean verify(int[] sequence, int first, int last){
        if (last - first<= 1){
            return true;
        }
        int root = sequence[last]; // 根节点
        int cutIndex = first;
        while (cutIndex < last && sequence[cutIndex] <= root){
            cutIndex++; //找到比根节点大的起点
        }
        for (int i = cutIndex; i<last; i++){
            if (sequence[i] < root){
                return false;
            }
        }
        return verify(sequence, first, cutIndex-1) && verify(sequence, cutIndex, last-1);
    }
}

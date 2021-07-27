package JianZhiOffer;

public class Solution33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int left, int right){
        if (left >= right) return true;
        int root = postorder[right];
        int index = left;
        while (index < right && postorder[index] < root) index++;
        int tmp = index;
        while (tmp < right && postorder[tmp] > root) tmp++;
        return tmp == right && verifyPostorder(postorder, left, index - 1) && verifyPostorder(postorder, index, right - 1);
    }
}

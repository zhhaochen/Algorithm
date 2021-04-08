public class Solution66 {
    public int[] constructArr(int[] a) {
        if(a.length == 0 || a.length == 1) return new int[0];
        int[] res = new int[a.length];
        res[0] = 1;
        for (int i = 1; i < a.length; i++){
            res[i] = res[i-1] * a[i-1];
        }
        int right = 1;
        for (int i = a.length - 1; i >= 0; i--){
            res[i] *= right;
            right *= a[i];
        }
        return res;
    }
}

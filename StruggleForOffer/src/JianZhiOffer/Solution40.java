package JianZhiOffer;

public class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        quickSort(arr, k - 1, 0, arr.length - 1);
        for (int i = 0; i < k; i++) res[i] = arr[i];
        return res;
    }

    private void quickSort(int[] arr, int k, int i, int j){
        if (i >= j) return;
        int left = i, right = j;
        while (left < right){
            while (left < right && arr[right] >= arr[i]) right--;
            while (left < right && arr[left] <= arr[i]) left++;
            swap(arr, left, right);
        }
        swap(arr, i, left);
        if (left == k) return;
        else if (left < k) quickSort(arr, k, left + 1, j);
        else quickSort(arr, k, i, left - 1);
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int[] res = new Solution40().getLeastNumbers(arr, 2);
    }
}

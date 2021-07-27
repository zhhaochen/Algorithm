package JianZhiOffer;

public class Solution17 {
    int[] res;
    char[] nums, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int n; // 位数
    int index; // res的索引
    int start; // 用于开始的位数，即去掉前导 0
    public int[] printNumbers(int n) {
        nums = new char[n];
        this.n = n;
        // 存结果
        res = new int[(int) (Math.pow(10, n) - 1)];
        // 存索引
        index = 0;
        // 从最后一位开始
        start = n - 1;
        dfs(0);
        return res;
    }

    private void dfs(int x){
        // 到头
        if (x == n){
            // 存值
            String num = new String(nums).substring(start);
            int c = Integer.parseInt(num);
            if (c != 0) res[index++] = c;
            // 如果当前的值已经到当前位数的头
            if (index == Math.pow(10, n - start) - 1) start--;
            return;
        }
        // 高位已固定，循环处理当前位
        for (char c : loop){
            nums[x] = c;
            // 递归处理下一位
            dfs(x + 1);
        }
    }
}

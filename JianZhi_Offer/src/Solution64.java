public class Solution64 {
    // 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    public int sumNums(int n) {
        boolean b = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}

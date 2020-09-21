package JianZhi_Offer;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution32 {
    public String PrintMinNumber(int[] numbers) {
        int len = numbers.length;
        if (len < 1)
            return "";
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                String s1 = numbers[j] + "" + numbers[j + 1];
                String s2 = numbers[j + 1] + "" + numbers[j];
                // 把拼接后大的移到末尾
                if (s1.compareTo(s2) > 0) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        String string = numbers[0] + "";
        for (int i = 1; i < len; i++)
            string += numbers[i];
        return string;
    }
}

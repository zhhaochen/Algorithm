package Challenge_30_Day.week7;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Input: num = "10200", k = 1
 * Output: "200"
 * Input: num = "10", k = 2
 * Output: "0"
 */
public class Remove_K_Digits {
    public static void main(String[] args) {
        String num = "10200";
        System.out.println(removeKdigits(num, 1));
    }
    public static String removeKdigits(String num, int k) {
        int len1 = num.length();
        int len2 = len1 - k; //输出的长度
        String result = "";
        int index = -1; //上一位的位置
        for (int i = 0; i < len2; i++) { // 根据长度每个位置
            index++;
            if (len2 - i != len1 - index){ //如果剩的位数一样时，直接相加即可
                int start = num.charAt(index) - '0';
                for (int j = index; j < k + i + 1; j++){
                    int tmp = num.charAt(j) - '0';
                    if (tmp < start){
                        index = j;
                        start = tmp;
                    }
                }
            }
            if (result.length()==0 && num.charAt(index)=='0'){ //防止出现0打头的情况
                continue;
            }else {
                result += num.charAt(index);
            }
        }
        return result.length()==0?"0":result; //防止输出空字符串
    }
}

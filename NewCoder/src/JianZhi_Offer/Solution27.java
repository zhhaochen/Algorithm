package JianZhi_Offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */

public class Solution27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.equals("") || str.length() == 0){
            return res;
        }
        generate(str.toCharArray(), 0, res);
        // 这里只是为了通过牛客网的测试所以需要排序，res已经包含了所有合理结果
        Collections.sort(res);
        return res;
    }

    public void generate(char[] chars, int index, ArrayList<String> res){
        // 如果是最后一个元素了，就输出排列结果
        if (chars.length - 1 == index) {
            res.add(new String(chars));
        } else {
            char tmp;
            // 对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
            for (int i = index; i < chars.length; i++) {
                // 下面是交换元素的位置，如果不相等或者自身的时候才可以交换
                if (chars[index] != chars[i] || i == index){
                    // 交换
                    swap(chars, index, i);
                    // 固定index位置，处理index后面剩下的位置
                    generate(chars, index + 1, res);
                    // 重新交换回来
                    swap(chars, index, i);
                }
            }
        }
    }
    public void swap(char[] chars, int index1, int index2){
        char tmp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = tmp;
    }
}

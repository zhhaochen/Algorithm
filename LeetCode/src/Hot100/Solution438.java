package Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int m = p.length();
        int n = s.length();
        int left = 0;
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        List<Integer> res = new ArrayList<>();
        for (char c : p.toCharArray()) pCnt[c-'a']++;
        for (int right = 0; right < n; right++){
            int curRight = s.charAt(right) - 'a';
            sCnt[curRight]++;
            // 保证窗口内每一个值的位置都不大于p字符串的每一个字母的值
            while (sCnt[curRight] > pCnt[curRight]){
                int curLeft = s.charAt(left) -'a';
                sCnt[curLeft]--;
                left++;
            }
            if (right - left + 1 == m) res.add(left);
        }
        return res;
    }
}

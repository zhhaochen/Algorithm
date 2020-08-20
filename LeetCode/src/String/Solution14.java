package String;

/**
 * 2020.4.16
 * Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 */
public class Solution14 {
    public static void main(String[] args) {
        String pre = "";
        pre += 'a';
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char str = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() || strs[j].charAt(i) - str != 0) {
                    return prefix;
                }
            }
            prefix += str;
        }
        return prefix;
    }
}

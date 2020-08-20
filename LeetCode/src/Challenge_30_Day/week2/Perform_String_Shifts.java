package Challenge_30_Day.week2;

/**
 * ou are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 */
public class Perform_String_Shifts {
    public String stringShift(String s, int[][] shift) {
        int perform = 0;
        for (int i=0; i<shift.length; i++){
            if (shift[i][0] == 0){
                perform -= shift[i][1];
            }else {
                perform += shift[i][1];
            }
        }
        perform %= s.length(); //防止越界，因为存在移动过后循环了回去，导致越界
        if (perform < 0){
            perform += s.length();
        }
        return s.substring(s.length()-perform) + s.substring(0, s.length() - perform);
    }
}

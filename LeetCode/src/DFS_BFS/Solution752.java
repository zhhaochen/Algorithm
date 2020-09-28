package DFS_BFS;

import java.util.*;

/**
 * 2020.09.28
 * 四位数密码，给定一个target，最少要几步才能转到
 * 同时转的过程中，不能触碰到deadends中的密码
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 */
public class Solution752 {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends.clone()));
        if (!visited.contains("0000")){
            queue.add("0000");
            visited.add("0000");
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // 找到目标，返回转动圈数
                if (cur.equals(target)) {
                    return step;
                }
                // 将相邻的且没重复的放入
                for (int j = 0; j < 4; j++) {
                    String up = upRoll(cur, j);
                    if (!visited.contains(up)) {
                        queue.add(up);
                        visited.add(up);
                    }
                    String down = downRoll(cur, j);
                    if (!visited.contains(down)) {
                        queue.add(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    // 向上旋转
    public String upRoll(String cur, int j) {
        char[] chars = cur.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] -= 1;
        }
        return new String(chars);
    }

    // 向下旋转
    public String downRoll(String cur, int j) {
        char[] chars = cur.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += 1;
        }
        return new String(chars);
    }
}

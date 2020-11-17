package Top100;

import java.util.Arrays;

/**
 * 2020.11.17
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 * 求的是长度
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 */
public class Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for (char task : tasks) {
            c[task - 'A']++;
        }
        Arrays.sort(c);
        int max = c[25];
        int i = 25;
        while (i >= 0 && c[i] == max) i--;
        // 根据出现的频率分块，前max-1块每块的长度是n+1，最后一块的长度是出现max频率的个数
        // 取max的原因是对AAABBB n = 0情况，需要与原有的进行比较
        return Math.max(tasks.length, (max - 1) * (n + 1) + (25 - i));
    }
}

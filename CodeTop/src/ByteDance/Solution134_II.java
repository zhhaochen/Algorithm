package ByteDance;

public class Solution134_II {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0, n = gas.length;
        // 选定起点
        while (index < n){
            int cnt = 0;
            int sumOfGas = 0;
            int sumOfCost = 0;
            // 需要访问过所有节点
            while (cnt < n){
                sumOfGas += gas[(index + cnt + n) % n];
                sumOfCost += cost[(index + cnt + n) % n];
                if (sumOfGas < sumOfCost) break;
                cnt++;
            }
            if (cnt == n) return index;
            // 确定下一个无法到达的节点
            index = (index + cnt) + 1;
        }
        return -1;
    }
}

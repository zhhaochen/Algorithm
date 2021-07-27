package ByteDance;

import Base.Employee;

import java.util.*;

public class Solution690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> map = new HashMap<>();
        // 记录 id 与 index 映射
        for (int i = 0; i < employees.size(); i++){
            Employee cur = employees.get(i);
            map.put(cur.id, i);
        }
        int importance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        while (!queue.isEmpty()){
            Employee cur = employees.get(map.get(queue.poll()));
            importance += cur.importance;
            for (int next : cur.subordinates) queue.offer(next);
        }
        return importance;
    }
}

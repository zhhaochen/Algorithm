package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            // 身高相同时，按照人数从少到多排队
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < people.length; i++){
            // 人数就是索引
            tmp.add(people[i][1], i);
        }
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++){
            res[i][0] = people[tmp.get(i)][0];
            res[i][1] = people[tmp.get(i)][1];
        }
        return res;
    }
}

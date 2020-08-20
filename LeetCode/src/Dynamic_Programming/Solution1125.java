package Dynamic_Programming;

/**
 * 2019.10.24
 * Smallest Sufficient Team
 *
 * In a project, you have a list of required skills req_skills, and a list of people.
 * The i-th person people[i] contains a list of skills that person has.
 * Consider a sufficient team: a set of people such that for every required skill in req_skills,
 * there is at least one person in the team who has that skill.
 * We can represent these teams by the index of each person: for example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
 * Return any sufficient team of the smallest possible size, represented by the index of each person.
 * You may return the answer in any order.  It is guaranteed an answer exists.
 *
 * Input: req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
 * Output: [1,2]
 */

import java.util.*;

public class Solution1125 {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skillBitPos = new HashMap<>();
        //为每个技能标上bit的位置
        for(String skill : req_skills) {
            skillBitPos.put(skill, skillBitPos.size());
        }
        int[] peopleArr = new int[people.size()];
        //每个people掌握的技能用bit来表示
        for(int i = 0; i < people.size(); i++) {
            peopleArr[i] = 0;
            for(String master : people.get(i)) {
                // 为每个技能建立索引，使用1移位操作，让不同技能拥有不同的权重表示
                // 或操作或者相加操作，计算每个人拥有的技能总权重，因为有了移位操作，不会出现不同技能相加得到的权重相同的情况
                // 即权重写作二进制表示时，1表示拥有此技能，0表示没有此技能
                peopleArr[i] |= (1 << skillBitPos.get(master));
            }
        }
        //一个广度优先的遍历算法
        long choose = findAns(peopleArr, req_skills.length);
        return getAns(choose, peopleArr.length);
    }

    long findAns(int[] peopleArr, int reqLen) {
        //使用队列实现广度优先
        Deque<long[]> bfs = new ArrayDeque<>();
        //因为每项技能都需要有人掌握，不妨选择掌握第一项技能的人出来加入队列中
        //用choose表示小队选中了那些人，用skilled表示目前小队已经拥有哪些技术
        for(int personPos = 0; personPos < peopleArr.length; personPos++) {
            int person = peopleArr[personPos];
            //找到掌握第一个技能的人，创建一只队伍
            if (masterSkill(person, 0)){
                long skilled = 0;
                skilled = skilled | person;
                long choose = 0;
                // choose的二进制表示即为选中的人都有谁
                choose = setBit(choose, personPos);
                bfs.offer(new long[]{choose, skilled});
            }
        }
        //在这一次for循环后，我们已经得到了一个队列，队列里的元素表示一个小队，每次循环，我们为小队加入一名队员。
        //所以最早返回的team成员最少
        while (bfs.size() > 0) {
            //取出一个待处理的小队
            long[] element = bfs.poll();
            long choose = element[0];
            long skilled = element[1];
            //找到队伍需要的技能，skilled是已有的技能，reqLen是总人数,needSkill是缺少的技能的第一个索引
            int needSkill = findSkill(skilled, reqLen);
            //如果没有需要的技能，说明人齐了，返回choose
            if (needSkill == reqLen){
                return choose;
            } else {
                //找到掌握技能的人
                for(int personPos = 0; personPos < peopleArr.length; personPos++) {
                    int person = peopleArr[personPos];
                    if (masterSkill(person, needSkill)){
                        //更新队伍技能集
                        long newSkilled = skilled | person;
                        //将他加入队伍
                        long newchoose = setBit(choose, personPos);
                        //如果没有需要的技能了返回
                        if(findSkill(newSkilled, reqLen) == reqLen) {
                            return newchoose;
                        }
                        //将该新队伍加入下轮查找
                        bfs.offer(new long[]{newchoose, newSkilled});
                    }
                }
            }
        }
        //there is not a team can satisfy requirement.
        return 0;
    }

    //注意是对long做位操作， 1l << pos
    long setBit(long val, long pos) {
        return val | 1l << pos;
    }
    boolean masterSkill(long val, long skillPos) {
        // 判断是否拥有第skillPos项技能
        return (val & (1l << skillPos)) != 0;
    }

    int[] getAns(long choose, int peopleLen) {
        List<Integer> ans = new ArrayList<>();
        for(int personPos = 0; personPos < peopleLen; personPos++) {
            if((choose & (1l << personPos)) > 0){
                ans.add(personPos);
            }
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    int findSkill(long skilled, int reqLen) {
        int needSkill = 0;
        while(needSkill < reqLen && masterSkill(skilled, needSkill)){
            needSkill++;
        }
        return needSkill;
    }
}

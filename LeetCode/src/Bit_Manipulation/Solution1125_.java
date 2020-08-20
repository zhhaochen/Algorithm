package Bit_Manipulation;

/**
 * 1 <= req_skills.length <= 16
 * 1 <= people.length <= 60
 * 1 <= people[i].length, req_skills[i].length, people[i][j].length <= 16
 * Elements of req_skills and people[i] are (respectively) distinct.
 * req_skills[i][j], people[i][j][k] are lowercase English letters.
 * Every skill in people[i] is a skill in req_skills.
 * It is guaranteed a sufficient team exists.
 * 注意添加队员相关操作，因为int型为4字节，当人数超过32个人时会出现错误，题目中人数少于60人，可以用long类型做位操作
 */

import java.util.*;

public class Solution1125_ {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        //存储技能的索引
        Map<String, Integer> indexOfSkill = new HashMap<>();
        for (String skill : req_skills) {
            indexOfSkill.put(skill, indexOfSkill.size());
        }
        // 每个人的技能
        int[] people_skill = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            people_skill[i] = 0;
            for (String skill : people.get(i)) {
                people_skill[i] |= (1 << indexOfSkill.get(skill));
            }
        }

        long choose = getTeam(people_skill, req_skills.length);
        int[] team = getTeam(choose, people.size());
        return team;
    }

    private long getTeam(int[] people_skill, int skillLen) {
        Deque<long[]> teamList = new ArrayDeque<>();
        //首先选择拥有第一项技能的放入队列
        for (int i = 0; i < people_skill.length; i++) {
            if (haveSkill(people_skill[i], 0)) {
                long choose = 0;
                choose = setTeam(choose, i);
                teamList.offer(new long[]{choose, people_skill[i]});
            }
        }
        while (teamList.size() > 0) {
            long[] team = teamList.poll();
            long choose = team[0];
            long skill = team[1];
            int newSkill = getNewSkill(skill, skillLen);
            if (newSkill == skillLen) {
                return choose;
            } else {
                for (int i = 0; i < people_skill.length; i++) {
                    if (haveSkill(people_skill[i], newSkill)) {
                        // 必须重新创建
                        long newChoose = setTeam(choose, i);
                        long newskill = skill | people_skill[i];
                        if (getNewSkill(newskill, skillLen) == skillLen) {
                            return newChoose;
                        }
                        teamList.offer(new long[]{newChoose, newskill});
                    }
                }
            }
        }
        return 0;
    }

    private boolean haveSkill(long skillList, int skill) {
        return (skillList & (1 << skill)) != 0;
    }

    private long setTeam(long choose, int index) {
        return choose | (1L << index);
    }

    private int getNewSkill(long skilled, int skillLen) {
        int newSkill = 0;
        while (newSkill < skillLen && haveSkill(skilled, newSkill)) {
            newSkill++;
        }
        return newSkill;
    }

    private int[] getTeam(long choose, int peopleLen) {
        List<Integer> team = new ArrayList<>();
        for (int i = 0; i < peopleLen; i++) {
            if ((choose & (1L << i)) != 0) {
                team.add(i);
            }
        }
        return team.stream().mapToInt(Integer::valueOf).toArray();
    }

}

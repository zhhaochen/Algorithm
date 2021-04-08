package Tencent;

public class Solution470 {
    public int rand10() {
        int cur = 7 * (rand7() - 1) + rand7();
        while (cur > 40){
            cur = 7 * (rand7() - 1) + rand7();
        }
        return (cur - 1) / 4 + 1;
    }

    private int rand7(){
        return 0;
    }
}

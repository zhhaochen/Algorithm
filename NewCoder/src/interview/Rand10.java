package interview;

/**
 * 使用rand3实现rand10
 */
public class Rand10 {

    public int rand10(){
        int res = 3*(rand3()-1) + rand3() + 9 * (rand3()-1);
        while (res > 20){
            res = 3*(rand3()-1) + rand3() + 9 * (rand3()-1);
        }
        return res/2 + res%2;
    }

    private int rand3(){
        return 0;
    }
}

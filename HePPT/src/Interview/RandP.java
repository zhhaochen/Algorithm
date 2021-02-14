package Interview;

/**
 * 如果预先给定的随机数生成器以p的概论生成0，(1-p)的概率生成1，
 * 通过该随机数生成器等概率生成的0,1
 * 思路：映射出两个等概率的结果
 */
public class RandP {

    // 产生等概率的0和1
    public int randP(){
        int num = randp() + randp();
        while (num == 1){
            num = randp() + randp();
        }
        // 此时num为 0 或 2
        return num / 2;
    }

    // 以 p的概率产生0，1-p的概率产生1
    public int randp(){
        return 0;
    }
}

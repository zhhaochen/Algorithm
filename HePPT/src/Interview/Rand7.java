package Interview;

/**
 * randm 实现 randn
 * 以m倍的规模不断扩大随机数范围知道超过n的范围
 * 之后使用while循环筛掉多余的使得概率不均等的即可
 */
public class Rand7 {
    public int rand7(){
        // 等概率产生 1 - 9
        int res = (rand3() - 1) * 3 + rand3();
        while (res > 7){
            res = (rand3() - 1) * 3 + rand3();
        }
        return res;
    }


    // 等概率产生 1, 2, 3
    public int rand3(){
        return (int) Math.random() * 3 + 1;
    }
}

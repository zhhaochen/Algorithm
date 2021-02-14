package Interview;

import java.util.Random;

/**
 * 一个文件中含有n个元素，只能遍历一遍，要求等概率随机取出其中之一
 * https://blog.csdn.net/chdhust/article/details/8533300
 *
 * 设第a个值，rand情况下选中它的概率为 1/a
 * 则后面需要都不选中
 * p = 1/a * (a/a+1) * (a+1/a+2) * ... * (n-1/n) = 1/n
 * 所以总体来说就是总概率
 * 当前是否选中与之前的无关，只与之后的有关，这样才能保证等概率
 * 所以只要是满足条件，就要替换picked
 */
public class RandomPick {

    public int randomPick(int[] file){
        Random random = new Random();
        int picked = file[0];
        int length = 1;
        while(length <= file.length){
            if (random.nextInt(length) == 0) picked = file[length - 1];
            length++;
        }
        return picked;
    }
}

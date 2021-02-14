package Interview;

import java.util.Scanner;

/**
 * 一瓶啤酒2元钱，2个啤酒瓶可换一瓶啤酒，4个啤酒瓶盖可换一瓶，10元最多喝多少瓶啤酒？
 */
public class WaterBottles {
    public int getTotal(int money, int price){
        int bottle = money / price;
        int cap = money / price;
        int res = money / price;
        while (bottle >= 2 || cap >= 4){
            if (bottle >= 2){
                res += bottle / 2;
                cap += bottle / 2;
                bottle = bottle % 2 + bottle / 2;
            }
            if (cap >= 4){
                res += cap / 4;
                bottle += cap / 4;
                cap = cap % 4 + cap / 4;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new WaterBottles().getTotal(20, 2);
        System.out.println(res);
    }

    /*
     * 一瓶啤酒2元钱，2个啤酒瓶可换一瓶啤酒，
     * 4个啤酒瓶盖可换一瓶，10元最多喝多少瓶啤酒？
     */
//    public static void main(String[] args) {
//        System.out.println("您的题目为：\n\t 一瓶啤酒2元钱，2个啤酒瓶可换一瓶啤酒，"
//                + "\n\t4个啤酒瓶盖可换一瓶，10元最多喝多少瓶啤酒？");
//        // 喝的所有的酒瓶数
//        int count = 0;
//        // 啤酒瓶的单价
//        int price = 2;
//        // 拥有的总钱数
//        System.out.println("您有多少钱请输入：");
//        Scanner sc = new Scanner(System.in);
//        int money = sc.nextInt();
//
//        // 原始的总钱数买的啤酒的瓶数
//        int countByMoney = money / price;
//        // 付给count
//        count += countByMoney;
//        System.out.println(money + "元钱\"买\"的酒为" + count + "瓶!");
//
//        // 剩余的酒瓶个数
//        int bottleCount = countByMoney;
//        // 剩余的酒瓶盖的个数
//        int coverCount = countByMoney;
//
//        // 设定循环结束的标志
//        boolean flag = true;
//        while (flag) {
//            // 新增的酒瓶盖数
//            int coverNew = 0;
//            // 新增的酒的瓶数为
//            int bottleNew = 0;
//            // 经过第一轮换酒：经过用酒盖换的酒，总共喝了11瓶，还剩3个空酒瓶，此时共有酒瓶盖3个
//            while (bottleCount >= 2) {
//                // ---- 用酒瓶换酒喝
//                // 换的酒的瓶数
//                int countByBottle = bottleCount / 2;
//                // 此时喝的所有的酒的瓶数为
//                count += countByBottle;
//                // 新增的酒瓶盖数
//                coverNew += countByBottle;
//                // 换后还剩的酒瓶的个数为 上次换剩的酒瓶的个数+新换的酒瓶的个数
//                bottleCount = bottleCount % 2 + countByBottle;
//            }
//            // 经过酒瓶换酒后总共剩余的酒瓶盖的数目为
//            coverCount = coverCount + coverNew;
//            while (coverCount >= 4) {
//                // ----用酒瓶盖换酒喝
//                int countByCover = coverCount / 4;
//                // 此时所喝的酒的瓶数为
//                count += countByCover;
//                // 新增的酒的瓶数为
//                bottleNew += countByCover;
//                // 换后还剩的酒瓶盖的个数为 上次换剩的酒瓶盖的个数+新换的酒瓶盖的个数
//                coverCount = coverCount % 4 + countByCover;
//            }
//            // 经过酒瓶换酒后总共剩余的酒瓶的个数为
//            bottleCount = bottleCount + bottleNew;
//            if (bottleCount < 2 && coverCount < 4) {
//                flag = false;
//                System.out.println("经过换酒，总共喝了" + count + "瓶，还剩" + bottleCount
//                        + "个空酒瓶，剩酒瓶盖" + coverCount + "个。");
//            }
//        }
//    }
}

package JianZhiOffer;

public class Solution65 {
    public int add(int a, int b) {
        int c = 0;
        int res = 0;
        int flag = 1;
        for (int i = 0; i < 32; i++){
            // 当前位
            res ^= (a ^ b ^ c) & flag;
            // 进位
            c = c == 0 ? (a & b & flag) << 1 : ((a | b) & flag) << 1;
            // 移位
            flag = flag << 1;
        }
        return res;
    }

    public int add_best(int a, int b){
        while (b != 0){
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}

package Interview;

// 没看懂
public class DiceNum {
    public int diceNum(int n, double[] data){
//        for (int i = 0; i < n; i++){
//            if (Math.random() < data[i])
//                return i+1;
//        }
//        return 0;
        double error = 0.000000001;
        long sum = 1;
        int result = 0;
        long[] aL = new long[n];
        double[] tmp = new double[n];
        boolean bl = false;
        while (true){
            double ero = 0.0;
            for (int i = 0; i < n; i++){
                aL[i] = (long) (data[i] * sum / 1.0);
                tmp[i] = (double) aL[i] / sum;
                ero += Math.abs(data[i] - tmp[i]);
                if (aL[i] > 0) bl = true;
            }
            if (ero < error && bl) break;
            else sum *= 10;
        }
        // 频数表示概率，找区间
        // 1970年1月1日零点到现在的过程中所经历的毫秒数
        long s = System.currentTimeMillis();
        long dice = s % sum;
        long tempValue = 0;
        for (int i = 0; i < n; i++){
            if (dice > tempValue) tempValue += aL[i];
            else{
                result = i + 1;
                break;
            }
        }
        return result;
    }
}

package JianZhi_Offer;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class Solution49 {

    public int StrToInt(String str) {
        if(str == null || str.length()==0){
            return 0;
        }
        int res = 0;
        int tag = 1;
        int start = 0;
        if(str.charAt(0) == '+'){
            start = 1;
        }else if(str.charAt(0) == '-'){
            tag = 0;
            start = 1;
        }
        for(int i = start; i<str.length(); i++){
            char now = str.charAt(i);
            if(now >= '0' && now <= '9'){
                res = res * 10 + (now - '0');
                // todo 需要检验一下是否越界
            }else{
                return 0;
            }
        }
        if(tag == 1){
            return res;
        }else{
            return -1 * res;
        }
    }
}

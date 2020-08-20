public class Solution {

    public static void main(String[] args) {
        String s = "babbcc";
        System.out.println(solution(s));
    }


//    private static int maxLen = 0;
//    private static String sub = "";
    public static String solution(String s) {
        String sub = "";
        //长度为1直接返回
        if(s.length() <= 1){
            return s;
        }
        //遍历每一个字符，分奇数偶数
        for(int i = 0;i < s.length()-1;i++){
            String sub1 = find(s,i,i);//奇数长度回文
            String sub2 = find(s,i,i+1);//偶数长度回文
            sub = sub1.length()>sub2.length()?(sub1.length()>sub.length()?sub1:sub):(sub2.length()>sub.length()?sub2:sub);
        }
        return sub;
    }
    public static String find(String s,int left,int right){
        String sub = "";
        //判断两边对称是否相等
        while (left >= 0 && right <= s.length()-1){
            if(s.charAt(left) == s.charAt(right)){
                if(right - left + 1 > sub.length()){
                    sub = s.substring(left , right+1);
                }
                //向两边扩散
                left --;
                right ++;
            }else{
                break;
            }
        }
        return sub;
    }
}

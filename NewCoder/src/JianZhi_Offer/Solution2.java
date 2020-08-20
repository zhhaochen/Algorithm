package JianZhi_Offer;

/**
 * 2019.11.4
 * 替换空格
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution2 {

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("   ");
        String s1 = replaceSpace(s);
        System.out.println(s1);
    }

    public static String replaceSpace(StringBuffer str) {
        int len = str.length();
        for (int i = 0; i < len; i++){
            if (str.charAt(i) == ' '){
                str.replace(i, i+1, "%20");
                // 发生替换后应改变长度，否则会漏掉
                len = len+2;
            }
        }
        return str.toString();
    }

    public static String replaceSpace2(StringBuffer str){
        return str.toString().replace(" ", "%20");
    }
}

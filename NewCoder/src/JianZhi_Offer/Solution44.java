package JianZhi_Offer;

/**
 * 例如，“student. a am I”，正确的句子应该是“I am a student.”。
 */
public class Solution44 {
    public String ReverseSentence(String str) {
        String[] words = str.split("\\ ");
        int len = words.length;
        if(len == 0){ //防止只有空格
            return str;
        }
        String result = "";
        for(int i=0; i<len; i++){
            result = " " + words[i] + result;
        }
        len = result.length();
        return result.substring(1, len);
    }
}


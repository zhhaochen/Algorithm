/**
 * 替换空格
 * 将空格替换为%20
 */
public class Solution5 {
    public static void main(String[] args) {
        String str = "We are happy";
        System.out.println(replaceStr(str));
    }
    //java简单
    /**
     *若用C/C++，时间复杂度为On算法应该是
     * 遍历，统计空格次数，假设内存足够，计算统计后的字符串长度
     * 双指针，从后向前进行复制替换，p1指向当前字符进行向前遍历，p2指向末尾进行复制
     * 没有空格时，将p1指向复制到p2指向，同时向前移动
     * 遇到空格时，p1向前移动1格，p2移动三格并存储
     */
    private static String replaceStr(String str){
        if (str == null)
            return null;
        str = str.replaceAll(" ", "%20");
        return str;
    }
    /**
     * 主要思想：从尾到头
     * 相关题目：
     * 两个排序数组A和B，内存在A的末尾有足够多的空余空间容纳B，实现把B中所有数组插入A且所有数字是排序的
     * 从头开始比较复制不可取，时间复杂度高
     * 双指针从末尾开始进行赋值
     */
}

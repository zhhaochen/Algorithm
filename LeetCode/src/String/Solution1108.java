package String;

/**
 * 2019.10.1
 * Defanging an IP Address
 *
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 *
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 */
public class Solution1108 {
    public static void main(String[] args) {
        String address = "1.1.1.1";
        String result = defangIPaddr(address);
        System.out.println(result);
    }
    public static String defangIPaddr(String address) {
        // 注意分割时转义
        String[] addr = address.split("\\.");
        return addr[0]+"[.]"+addr[1]+"[.]"+addr[2]+"[.]"+addr[3];
    }
}

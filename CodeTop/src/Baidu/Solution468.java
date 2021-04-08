package Baidu;

public class Solution468 {
    public String validIPAddress(String IP) {
        int count4 = 0, count6 = 0;
        for (int i = 0; i < IP.length(); i++){
            if (IP.charAt(i) == '.') count4++;
            if (IP.charAt(i) == ':') count6++;
        }
        if (count4 == 3) return validIPv4(IP);
        if (count6 == 7) return validIPv6(IP);
        return "Neither";
    }

    public String validIPv4(String IP){
        String[] ips = IP.split("\\.");
        if (ips.length != 4) return "Neither";
        for (String ip : ips){
            // 长度错误
            if (ip.length() == 0 || ip.length() > 3) return "Neither";
            // 如果有先导零
            if (ip.charAt(0) == '0' && ip.length() != 1) return "Neither";
            // 验证是不是数字
            for (int i = 0; i < ip.length(); i++) {
                if (ip.charAt(i) <'0' || ip.charAt(i) >'9') return "Neither";
            }
            // 验证数字的大小
            if (Integer.valueOf(ip) > 255) return "Neither";
        }
        return "IPv4";
    }

    public String validIPv6(String IP){
        String[] ips = IP.split(":");
        if (ips.length != 8) return "Neither";
        String map = "0123456789abcdefABCDEF";
        for (String ip : ips){
            if (ip.length() == 0 || ip.length() > 4) return "Neither";
            for (char c : ip.toCharArray()){
                if (map.indexOf(c) == -1) return "Neither";
            }
        }
        return "IPv6";
    }

    public static void main(String[] args) {
        new Solution468().validIPAddress(".1..");
    }
}

package Amazon;

public class Solution1138 {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        char[] chars = target.toCharArray();
        // 开始
        char cur = 'a';
        for (char c : chars){
            // 目标的节点
            int target_x = (c - 'a') / 5;
            int target_y = (c - 'a') % 5;
            // 如果当前和目标不一致
            if (cur != c){
                // 如果起点是 z
                if (cur == 'z'){
                    sb.append('U');
                    alphabetBoardPath('u', c, sb);
                }
                // 如果终点是 z
                else if (c == 'z'){
                    alphabetBoardPath(cur, 'u', sb);
                    sb.append('D');
                }
                else alphabetBoardPath(cur, c, sb);
            }
            sb.append('!');
            cur = c;
        }
        return sb.toString();
    }

    // 找到目标位置
    private void alphabetBoardPath(char start, char end, StringBuilder sb){
        int start_x = (start - 'a') / 5;
        int start_y = (start - 'a') % 5;
        int end_x = (end - 'a') / 5;
        int end_y = (end - 'a') % 5;
        // 判断四个方向往哪儿走
        // 先判断上还是下，走到同一行
        if (start_x < end_x) for (int i = start_x; i < end_x; i++) sb.append('D');
        else for (int i = end_x; i < start_x; i++) sb.append('U');
        // 再判断左右，走到同一列
        if (start_y < end_y) for (int i = start_y; i < end_y; i++) sb.append('R');
        else for (int i = end_y; i < start_y; i++) sb.append('L');
    }
}

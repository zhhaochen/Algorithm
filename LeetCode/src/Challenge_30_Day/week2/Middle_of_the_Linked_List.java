package Challenge_30_Day.week2;



public class Middle_of_the_Linked_List {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p!=null){
            count++;
            p = p.next;
        }
        count /= 2;
        p = head;
        for (int i=0; i<count; i++){
            p = p.next;
        }
        return p;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

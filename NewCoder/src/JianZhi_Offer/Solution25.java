package JianZhi_Offer;

/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（
注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution25 {
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null){
            return null;
        }
        //1、对对每一个结点在后面进行复制
        RandomListNode tmp = pHead;
        while (tmp != null){
            RandomListNode node = new RandomListNode(tmp.label);
            node.next = tmp.next;
            tmp.next = node;
            tmp = node.next;
        }
        //2、对random进行复制
        tmp = pHead;
        while (tmp!=null){
            RandomListNode clone = tmp.next;
            if (tmp.random != null){
                clone.random = tmp.random.next;
            }
            tmp = clone.next;
        }
        //3、拆分
        RandomListNode head = pHead.next;
        tmp = pHead;
        while (tmp.next!=null){
            RandomListNode next = tmp.next;
            tmp.next = next.next;
            tmp = next;
        }
        return head;
    }
}
class RandomListNode{
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
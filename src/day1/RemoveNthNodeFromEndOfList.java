package day1;

import structure.ListNode;

/**
 * @author tanghao
 * @date 2022/2/10
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚节点
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode r = dump;
        // 总长为k, 需要寻找正序为k-n的节点 ,r先走n步,然后r走到null时则是k-n的距离
        for (int i = 0; i <= n; i++) {
            r = r.next;
        }
        ListNode l = dump;
        while (r != null){
            l = l.next;
            r= r.next;
        }
        l.next = l.next.next;
        return dump.next;
    }
}

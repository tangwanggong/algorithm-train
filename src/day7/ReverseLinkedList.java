package day7;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 1->2->3->4->5
        // 递归到最后last 就是最后一个节点 5
        ListNode last = reverseList(head.next);
        // 当前节点的下个节点的下个节点指向自己 1->2->3->4<=>5
        head.next.next = head;
        // 当前节点的下个节点设置null 1->2->3->4<-5
        head.next = null;
        return last;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

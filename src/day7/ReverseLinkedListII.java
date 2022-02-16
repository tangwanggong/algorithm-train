package day7;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {
    ListNode listNode = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1){
            return reverseN(head,right);
        }
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }
    public ListNode reverseN(ListNode head, int n) {
        if(n == 1){
            // 当n=1时,说明已经到了终点,listNode指向不需要反转的节点
            listNode = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        // 最终最开始反转的位置指向不需要反转的节点
        head.next = listNode;
        return last;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next = null;
        // 每反转一个节点，都指向左边第一个的下个节点
        // pre 永远指向需要反转节点left的左边第一个
        // cur 指向当前需要反转的节点
        // next 永远指向cur.next
        for (int i = 0; i < right-left; i++) {
            // next 指向cur.next
            next = cur.next;
            // 当前需要反转的节点的下个指向next的下个
            cur.next = next.next;
            // next的下个指向左边第一个的下个
            next.next = pre.next;
            // 左边第一个的下个指向next
            pre.next = next;
        }
        return dummy.next;
    }
}

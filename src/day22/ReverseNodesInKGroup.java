package day22;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @date 2022/4/12
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode a = head,b = head;
        // 将b遍历到第k+1个元素
        for (int i = 0; i < k; i++) {
            // 如果当前不满足k个直接返回结果
            if(b == null){
                return head;
            }
            b = b.next;
        }
        // 已经反转的节点（a到b之间的节点已反转）
        ListNode newHead = reverseKGroupHelper(a,b);
        // head的next ,也就是newHead的末尾节点指向剩下的反转节点
        a.next = reverseKGroup(b,k);
        return newHead;
    }

    // 将a到b之前节点全部反转
    public ListNode reverseKGroupHelper(ListNode a, ListNode b) {
        ListNode cur = a,pre = null;
        while (cur != b){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

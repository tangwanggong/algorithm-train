package day22;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @date 2022/4/12
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head,fast = head;
        // 找到反转点
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果是奇数,取slow的下个为反转点
        if(fast != null){
            slow = slow.next;
        }
        ListNode left = head;
        // 反转后半部分
        ListNode right = reverse(slow);
        // 一一比较
        while (right != null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode cur = node,pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

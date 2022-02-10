package day1;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @date 2022/2/10
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;
        // 通过快慢指针判断是否为环形
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        // 此情况说明不是环形
        if(fast == null || fast.next == null){
            return null;
        }
        // 当为环形时,slow走k步,fast走2k步,则环形总长为k,设相遇点距环形起点长为m,则slow走k-m为环形起点,fast已经从环形起点走了m步,则需要k-m步也回到环形起点
        // 将slow设置为head,则slow和fast相同速度,等遇见时则为环形起点
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

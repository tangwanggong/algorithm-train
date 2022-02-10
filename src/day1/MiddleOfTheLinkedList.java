package day1;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @date 2022/2/10
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        // slow 慢指针,fast 快指针 初始都指向头
        ListNode slow = head , fast = head;
        // 当快指针为空或者快指针的下个节点为空,代表快指针已经走完整个节点
        while (fast != null && fast.next != null){
            // 慢指针每次走1步
            slow = slow.next;
            // 快指针每次走2步
            fast = fast.next.next;
        }
        // 快指针走完，慢指针走了一半
        return slow;
    }
}

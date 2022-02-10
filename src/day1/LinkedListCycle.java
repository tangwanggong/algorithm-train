package day1;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @date 2022/2/10
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // slow 慢指针,fast 快指针 初始都指向头
        ListNode slow = head, fast = head;
        // 当快指针为空或者快指针的下个节点为空,代表快指针已经走完整个节点,说明不是环形
        while (fast != null && fast.next != null){
            // 慢指针每次走1步
            slow = slow.next;
            // 快指针每次走2步
            fast = fast.next.next;
            // 因为快指针比慢指针走的快,所以如果是环形,二者会遇上,指向的对象会相同, 如果两个指针指向相同，说明是环形
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}

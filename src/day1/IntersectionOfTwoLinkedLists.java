package day1;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @date 2022/2/10
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA , q = headB;
        // 如果 headA 和 headB 存在相交节点,则尾部对齐之后,肯定存在相同的节点,下面主要是对齐尾部的过程
        while (p != q){
            // 判断headA,如果还是到尾部还是为空,则补上headB对齐尾部
            p = p == null ? headB : p.next ;
            // 同上
            q = q == null ? headA : q.next ;
        }
        return p;
    }
}

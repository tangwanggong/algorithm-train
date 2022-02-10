package day1;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @date 2022/2/10
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建虚节点，方便操作
        ListNode dump = new ListNode(-1);
        // 当前节点引用指向虚节点
        ListNode cur = dump;
        while (l1 != null && l2 != null){
            // 比较大小
            if(l1.val<l2.val){
                // 如果是第一次,cur为虚节点的引用,不是第一次,cur代表当前尾部的节点引用,然后指向当前小的节点
                cur.next = l1;
                // l1 修改为 l1的下个节点
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            // cur修改为尾部的节点
            cur = cur.next;
        }
        // 当 l1 不为空,说明l2 为空,因为有序,直接将当前节点的下个节点设置为剩余的l1
        if (l1 != null){
            cur.next = l1;
        }
        // 同上
        if (l2 != null){
            cur.next = l2;
        }
        // 返回虚节点的下个节点,避免了一些空指针的判断
        return dump.next;
    }
}

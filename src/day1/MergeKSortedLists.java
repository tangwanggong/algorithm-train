package day1;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @date 2022/2/10
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        // 左边边界等于右边,已经是最底层的递归,无法寻找下个节点,直接返回节点
        if(start == end){
            return lists[start];
        }
        // 如果左边边界值大于右边,则返回空
        if(start > end){
            return null;
        }
        int mid = (start+end) / 2;
        // 使用递归先合并左边的,然后递归右边
        ListNode left = merge(lists,start,mid);
        ListNode right = merge(lists,mid+1,end);
        // 在递归中，会合并两个单个节点，最终合并时，最顶层的left 和 right 已经合并好了
        return doMerge(left,right);
    }

    private ListNode doMerge(ListNode l1, ListNode l2) {
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

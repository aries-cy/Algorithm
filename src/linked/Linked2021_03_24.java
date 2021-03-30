package linked;

import model.SinglyListNode;

/**
 * TODO 描述
 *
 * @author cy
 */
public class Linked2021_03_24 {


    /**
     * 删除排序链表中的重复元素:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
     */
    public SinglyListNode deleteDuplicates(SinglyListNode head) {
        SinglyListNode cur = head;
        while (cur!=null&&cur.next!=null){
            if(cur.val!=cur.next.val){
                cur = cur.next;
            }else {
                cur.next = cur.next.next;
            }
        }
        return head;
    }

    /**
     * 删除排序链表中的重复元素2：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     */
    public SinglyListNode deleteDuplicates2(SinglyListNode head) {
        SinglyListNode pre = new SinglyListNode(-1, head);
        SinglyListNode cur = pre;
        while (cur.next != null) {
            SinglyListNode next = cur.next;
            while (next != null && cur.next.val == next.val) {
                next = next.next;
            }
            if (cur.next.next == next) {
                cur = cur.next;
            } else {
                cur.next = next;
            }
        }
        return pre.next;
    }

    /**
     * 反转链表：https://leetcode-cn.com/problems/reverse-linked-list/
     */
    public SinglyListNode reverseList(SinglyListNode head) {
        SinglyListNode pre = null;
        SinglyListNode cur = head;
        while (cur!=null){
            SinglyListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

package linked;

import model.SinglyListNode;

/**
 * TODO 描述
 *
 * @author cy
 */
public class Linked2021_03_30 {

    /**
     * 重排链表： https://leetcode-cn.com/problems/reorder-list/submissions/
     * 涉及 双指针找到链表中点、反转一个链表、合并链表
     * @param head
     */
    public void reorderList(SinglyListNode head) {
        //分割成两个链表
        SinglyListNode slow = head;
        SinglyListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        SinglyListNode newHead = slow.next;
        slow.next = null;

        //反转后面一个链表
        newHead = revert(newHead);

        //合并链表
        while(newHead!=null){
            SinglyListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }

    public static SinglyListNode revert(SinglyListNode node){
        SinglyListNode pre = null;
        SinglyListNode cur = node;
        while(cur!=null){
            SinglyListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 回文链表： https://leetcode-cn.com/problems/palindrome-linked-list/
     * @param head
     * @return
     */
    public boolean isPalindrome(SinglyListNode head) {
        //分割成两个链表，然后反转，再进行比较
        SinglyListNode slow = head;
        SinglyListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        SinglyListNode newHead = slow.next;
        slow.next = null;

        //反转链表
        newHead = revert(newHead);

        //比较
        while(head!=null&&newHead!=null){
            if(head.val!=newHead.val){
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
}

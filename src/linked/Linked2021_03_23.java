package linked;

import model.SinglyListNode;

/**
 * 2021-03-23 链表算法题
 *
 * @author cy
 */
public class Linked2021_03_23 {

    /**
     * 两数相加：https://leetcode-cn.com/problems/add-two-numbers/
     * 1.定义指针cur，链遍历单链表
     * 2.定义int变量s，记录两个节点的和，通过 s /= 10 来记录前面相加的 十位 上的数字 ，s % 10 得到个位上的数字
     */
    public SinglyListNode addTwoNumbers(SinglyListNode l1, SinglyListNode l2) {
        SinglyListNode sum = new SinglyListNode(-1);
        //结果的指针
        SinglyListNode cur = sum;
        SinglyListNode cur1 = l1;
        SinglyListNode cur2 = l2;
        //思路：同时遍历两个链表，并对节点进行相加，生成新链表的节点
        int s = 0;
        while (cur1 != null || cur2 != null) {
            s /= 10;
            if (cur1 != null) {
                s += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                s += cur2.val;
                cur2 = cur2.next;
            }
            cur.next = new SinglyListNode(s % 10);
            cur = cur.next;
        }
        if (s / 10 == 1) {
            cur.next = new SinglyListNode(1);
        }
        return sum.next;
    }

    /**
     * 删除链表中的倒数第N个节点：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
     * 1.通过双指针的方式删除倒数第N个节点
     * 2.链表的迭代
     */
    public SinglyListNode removeNthFromEnd(SinglyListNode head, int n) {
        SinglyListNode result = new SinglyListNode(-1, head);
        //思路：双指针找到链表中的倒数第N个节点 并进行删除
        SinglyListNode pre = result;
        SinglyListNode after = head;
        while (n > 0) {
            after = after.next;
            n--;
        }
        while (after != null) {
            after = after.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return result.next;
    }

    /**
     * 合并两个有序链表：https://leetcode-cn.com/problems/merge-two-sorted-lists/
     * 1.迭代法
     * 2.定义一个新的空链表，分别迭代l1,l2将满足条件的节点给到新链表的next
     */
    public SinglyListNode mergeTwoLists(SinglyListNode l1, SinglyListNode l2) {
        SinglyListNode result = new SinglyListNode(-1);
        //遍历两个链表，比较大小，将新链表的next节点指向下一个节点
        SinglyListNode cur = result;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = new SinglyListNode(l2.val);
                l2 = l2.next;
            } else {
                cur.next = new SinglyListNode(l1.val);
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return result.next;
    }
}

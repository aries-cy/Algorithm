package model;

/**
 * 单链表 数据结构
 * 单链表可以衍生出  环形链表、静态链表、双链表
 *
 * @author cy
 */
public class SinglyListNode {

    public int val;
    public SinglyListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public SinglyListNode getNext() {
        return next;
    }

    public void setNext(SinglyListNode next) {
        this.next = next;
    }

    public SinglyListNode(int val) {
        this.val = val;
    }

    public SinglyListNode(int val, SinglyListNode next) {
        this.val = val;
        this.next = next;
    }
}

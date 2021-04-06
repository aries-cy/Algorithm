package linked;

import model.SinglyListNode;

import java.util.Stack;

/**
 * TODO 描述
 *
 * @author cy
 */
public class Linked2021_04_06 {

    /**
     * 两数相加 II : https://leetcode-cn.com/problems/add-two-numbers-ii/
     * @param l1 链表1
     * @param l2 链表2
     * @return 结果链表
     */
    public SinglyListNode addTwoNumbers(SinglyListNode l1, SinglyListNode l2) {
        //逆序使用栈来实现
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int y = 0;
        SinglyListNode result = null;
        while(!s1.isEmpty()||!s2.isEmpty()||y>0){
            int sum = (s1.isEmpty() ? 0 : s1.pop())
                    + (s2.isEmpty() ? 0 : s2.pop())
                    + y;
            SinglyListNode node = new SinglyListNode(sum%10);
            y = sum/10;
            //向链表头部添加节点，并把指针指向头节点
            node.next = result;
            result = node;
        }
        return result;
    }
}

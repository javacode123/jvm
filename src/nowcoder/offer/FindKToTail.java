package nowcoder.offer;

import java.util.Scanner;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKToTail {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        System.out.println(new FindKToTail().FindKthToTail(root, 2).val);
    }

    // 两个节点相隔 k 个,当最后一个为空, 前一个就是
    public ListNode FindKthToTail(ListNode head,int k) {

        ListNode temp = head;

        while (k > 0 && head != null) {
            head = head.next;
            k--;
        }

        if (k > 0) {
            return null;
        }

        while (head != null) {
            head = head.next;
            temp = temp.next;
        }

        return temp;

    }

}

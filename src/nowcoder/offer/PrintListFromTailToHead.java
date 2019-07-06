package nowcoder.offer;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {

    public static void main(String[] args) {
        ListNode l = new ListNode(8);
        l.next = new ListNode(9);
        l.next.next = new ListNode(10);
        ArrayList<Integer> arr = new PrintListFromTailToHead().printListFromTailToHead2(l);
        for (Integer i: arr) {
            System.out.println(i);
        }
    }

    // 使用头插法
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode head = new ListNode(-1);

        while (listNode != null) {
            ListNode p = listNode;
            listNode = listNode.next;
            p.next = head.next;
            head.next = p;
        }

        head = head.next;

        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        return arr;

    }

        // 使用栈
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();

        while (listNode != null) {
            s.push(listNode.val);
            listNode = listNode.next;
        }

        while (!s.empty()) {
            arr.add(s.pop());
        }

        return arr;

    }

    // 使用递归
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<>();
        inserArray(arr, listNode);

        return arr;
    }

    public void inserArray(ArrayList<Integer> arr, ListNode list) {
        if (list == null) {
            return;
        }
        inserArray(arr, list.next);
        arr.add(list.val);
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

}
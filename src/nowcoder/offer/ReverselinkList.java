package nowcoder.offer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverselinkList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root = new ReverselinkList().ReverseList(root);

        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }

    }

    public ListNode ReverseList(ListNode head) {
        ListNode root = new ListNode(-1), p;

        while (head != null) {
            p = head;
            head = head.next;
            p.next = root.next;
            root.next = p;
        }

        return root.next;
    }

}

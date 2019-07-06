package nowcoder.offer;

public class MergeLinkList {

    public static void main(String[] args) {
        ListNode h = new ListNode(2);
        h.next = new ListNode(3);
        h.next.next = new ListNode(4);
        ListNode h1 = new ListNode(2);
        h1.next = new ListNode(3);
        h1.next.next = new ListNode(4);
        ListNode l = new MergeLinkList().Merge(h, h1);

        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }

    }

    public ListNode Merge(ListNode list1,ListNode list2) {

        ListNode list3 = new ListNode(-1), p=list3;

        while (list1!=null && list2!=null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        p.next = (list1==null) ? list2 : list1;

        return list3.next;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}

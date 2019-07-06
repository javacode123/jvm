package nowcoder.offer;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNodeImpl {

    // 思路： 两个链表有公共结尾, 链表 a 长度为 la+lc, 链表 b 长度为 lb+lc, lc 为公共长度
    // la + lc + lb = lb + lc + la 循环遍历总会相遇
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;

        while (p1 != p2) {
            p1 = (p1==null) ? pHead2 : p1.next;
            p2 = (p2==null) ? pHead1 : p2.next;
        }

        return p1;

    }

}

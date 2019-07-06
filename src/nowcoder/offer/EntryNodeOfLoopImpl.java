package nowcoder.offer;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoopImpl {
    // 思路：链表分为三快 1:非环部分(x), 2:环部分(y+z), fast 每次移动一个节点, slow 每次移动两个节点
    // 在环中的一个节点(z)相遇, 则 slow 移动 x+y, fast 移动 x+2*y+z, 2*(x+y) = x+2*y+z, x=z
    // fast 从头指针移动, 与 slow 相遇时就是入口节点
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead, fast = pHead;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow && fast != null);

        if (fast == null) {
            return null;
        }

        fast = pHead;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}

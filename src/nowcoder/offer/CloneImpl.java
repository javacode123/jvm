package nowcoder.offer;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CloneImpl {

    public static void main(String[] args) {
        RandomListNode pHead = new RandomListNode(1);
        pHead.next = new RandomListNode(2);
        RandomListNode p = new CloneImpl().Clone(pHead);
        System.out.println(p.next.label);
    }

    // 难点在于如何链接随机节点
    // 先复制顺序节点,根据相对位置进行链接
    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null) {
            return pHead;
        }

        // 复制节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        // random 节点链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        // 分离链表
        cur = pHead;
        RandomListNode cloneHead = cur.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }

        return cloneHead;
    }

}

class RandomListNode {

    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

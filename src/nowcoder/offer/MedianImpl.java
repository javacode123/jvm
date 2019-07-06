package nowcoder.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 */
public class MedianImpl {

    public static void main(String[] args) {
        int num = 6;
        int[] arr = {0,1,2,3,4,5};
        int low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] >= num) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        System.out.println(low);
    }

    // 思路： 使用两个堆, 堆顶表示中间数据, 左边大根堆（左边最大值）, 右边小根堆（右边最小值）
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2)->o2-o1);
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private int N = 0;

    public void Insert(Integer val) {
        // 总数为偶数, 进入右半区
        if (N%2 == 0) {
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
    }

    public Double GetMedian() {
        if (N % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double) right.peek();
    }
}

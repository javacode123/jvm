package nowcoder.offer;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class FindContinuousSequenceImpl {

    // 思路：从 i 从 1-sum 依次递推，寻找和为 sum 的序列
    // 采取移动的方式, 不断寻找合适的队列
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int start = 1, end = 2, curSum = 3;

        while (end < sum) {
            // 当前序列和小于 sum, end 后移
            if (curSum < sum) {
                end++;
                curSum += end;
            } else {
                // 当前序列和大于 sum, start 后移
                if (curSum > sum) {
                    curSum -= start;
                    start++;
                } else {
                    // 序列和等于 sum
                    ArrayList<Integer> l = new ArrayList<>();
                    for (int i=start; i<=end; i++) {
                        l.add(i);
                    }
                    res.add(l);
                    curSum -= start;
                    start++;
                    end++;
                    curSum += end;
                }
            }
        }

        return res;

    }

}

package nowcoder.offer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSumImpl {

    // 思路：定义两个指针, 一个是头指针, 一个是尾指针, 如果 sum > target, 尾指针移动
    // 否则头指针移动
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int cur = 0, left = 0, right = array.length-1;

        while (left < right) {
            cur = array[left] + array[right];
            if (cur == sum) {
                res.add(array[left]);
                res.add(array[right]);
                return res;
            }
            if (cur < sum) {
                left++;
            } else {
                right--;
            }
        }

        return res;

    }

}

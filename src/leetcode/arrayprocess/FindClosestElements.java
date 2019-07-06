package leetcode.arrayprocess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
 * 返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 */
public class FindClosestElements {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        new FindClosestElements().findClosestElements(a, 2, 2);

    }

    /**
     * 输入: [1,2,3,4,5], k=4, x=3
     * 输出: [1,2,3,4]
     *
     * 输入: [1,2,3,4,5], k=4, x=-1
     * 输出: [1,2,3,4]
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> l = new ArrayList<>();
        int maxDistance = 0;
        // 初始化 k 个数
        for (int i=0; i<k; i++) {
            l.add(arr[i]);
            maxDistance = Math.max(Math.abs(arr[i]-x), maxDistance);
        }

        // 判断是否要更新数组, 因为数组是已经排序的, 所以距离最远的是 第一个数
        for (int i=k; i<arr.length; i++) {
            // 防止前几个数据相同
            if (Math.abs(arr[i]-x) < maxDistance || l.get(0).equals(arr[i])) {
                l.remove(0);
                l.add(arr[i]);
                maxDistance = Math.max(Math.abs(l.get(0)-x),
                        Math.abs(l.get(l.size()-1)-x));
            } else {
                break;
            }
        }

        return l;
    }

}

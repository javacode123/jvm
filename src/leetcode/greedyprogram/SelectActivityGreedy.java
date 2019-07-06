package leetcode.greedyprogram;

import java.util.*;

/**
 * 活动选择问题
 * 问题描述：有 n 个活动 S={a0, a1, a2, a3, an-1}, 求解区间 [i,j] 之间的最大活动数
 */
public class SelectActivityGreedy {

    public static void main(String[] args) {
        List<Activity> list = init();
        sortActivityList(list);
        greedySlove(list);
        System.out.println();
        System.out.print("[" + list.get(0).start + "," + list.get(0).end + "]" + " ");
        gredyRecur(list, 0, 1);

    }

    // 使用贪心算法解决活动选择问题
    // 活动按照结束时间排好序, 每次选择最早结束的活动, 即能保证活动数目最大
    public static void greedySlove(List<Activity> list) {

        // 最先选择的是第一个活动
        int k = 0;
        Activity pre = list.get(k);
        System.out.print("[" + pre.start + "," + pre.end + "]" + " ");

        for (k=1; k<list.size(); k++) {
            Activity next = list.get(k);
            // 最早结束
            if (next.start >= pre.end) {
                System.out.print("[" + next.start + "," + next.end + "]" + " ");
                pre = next;
            }
        }

    }

    // 使用递归的方式解决

    /**
     *
     * @param list
     * @param m 上一个被选择的活动
     * @param k 比较的活动
     */
    public static void gredyRecur(List<Activity> list, int m, int k) {

        if (k >= list.size() || m >= list.size()) {
            return;
        }

        Activity pre = list.get(m);
        Activity next = list.get(k);

        if (next.start >= pre.end) {
            System.out.print("[" + next.start + "," + next.end + "]" + " ");
            m = k;
        }

        k++;
        gredyRecur(list, m, k);

    }

    // 活动数据初始化
    public static List init() {

        List<Activity> a = new ArrayList();

        a.add(new Activity(1, 4));
        a.add(new Activity(3, 5));
        a.add(new Activity(0, 6));
        a.add(new Activity(5, 7));
        a.add(new Activity(3, 9));
        a.add(new Activity(5, 9));
        a.add(new Activity(6, 10));
        a.add(new Activity(8, 11));
        a.add(new Activity(8, 12));
        a.add(new Activity(2, 14));
        a.add(new Activity(12, 16));

        return a;
    }

    public static void sortActivityList(List<Activity> list) {
        list.sort(new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                if (o1.end >= o2.end) {
                    return 1;
                }
                return 0;
            }
        });
    }

    public static void printActivityList(List<Activity> list) {

        for (Activity a : list) {
            System.out.println(a.end);
        }

    }

    private static class Activity {

        public Integer start;
        public Integer end;

        public Activity(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

    }

}

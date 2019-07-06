package leetcode.greedyprogram;

/**
 * 活动选择问题
 * 问题描述：有 n 个活动 S={a0, a1, a2, a3, an-1}, 求解区间 [i,j] 之间的最大活动数
 */
public class SelectActivity {

    public static void main(String[] args) {

        dynamicProgram(init());

    }

    // 活动数据初始化
    public static Activity[] init() {

        Activity a[] = new Activity[11];

        a[0] = new Activity(1, 4);
        a[1] = new Activity(3, 5);
        a[2] = new Activity(0, 6);
        a[3] = new Activity(5, 7);
        a[4] = new Activity(3, 9);
        a[5] = new Activity(5, 9);
        a[6] = new Activity(6, 10);
        a[7] = new Activity(8, 11);
        a[8] = new Activity(8, 12);
        a[9] = new Activity(2, 14);
        a[10] = new Activity(12, 16);

        return a;
    }

    // 使用动态规划的思路求解
    // 思路：c[i,j](ai结束之后,aj开始之前)之间的最优活动个数,
    public static void dynamicProgram(Activity a[]) {

        int length = a.length;
        // 存放最优解
        Integer c[][] = new Integer[length][length];
        // 存放解
        Integer r[][] = new Integer[length][length];

        for (int i=0; i<length; i++) {
            for (int j = 0; j < length; j++) {
                c[i][j] = 0;
                r[i][j] = 0;
            }
        }


        for (int i=0; i<length; i++) {
            for (int j=0; j<length; j++) {
                // 判断活动 i 结束之后和 活动 j 开始之前是否可以进行活动 k
                for (int k=0; k<length; k++) {
                    if (a[i].end <= a[k].start && a[k].end <= a[j].start) {
                        if (c[i][j] < c[i][k]+c[k][j]+1) {
                            c[i][j] = c[i][k]+c[k][j]+1;
                            r[i][j] = k;
                        }
                    }
                }
            }
        }

        // 求解活动
        int max=0, li=0, lj=0;

        // 最大活动数
        for (int i=0; i<length; i++) {
            for (int j=0; j<length; j++) {
                if (c[i][j] > max) {
                    max = c[i][j];
                    li = i;
                    lj = j;
                }
            }
        }

        System.out.print(li + " ");
        printActivities(r, li, lj);
        System.out.print(lj + " ");

    }

    public static void printActivities(Integer[][] r, int i, int j) {

        if (r[i][j] != 0) {
            printActivities(r, i, r[i][j]);
            printActivities(r, r[i][j], j);
            System.out.print(r[i][j]+" ");
        }

    }

    public static void print(Integer[][] c) {

        for (int i=0; i<c.length; i++) {
            for (int j=0; j<c[0].length; j++) {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
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

package nowcoder.offer;

import java.util.*;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {1,1,2,2,2,6,6,7,7,8,8,9,9,10,10,11,111,11}, num1={0}, num2={0};
        s.findNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0] + "-" + num2[0]);
    }

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    private static class Solution {

        public void findNumsAppearOnce(int[] array, int[] num1, int[] num2) {

            if (array.length < 2) {
                return;
            }

            boolean flag1 = true, flag2 = true;
            int n, count;

            for (int i=0; i<array.length; i++) {

                if (flag1==false && flag2==false) {
                    break;
                }

                n = array[i];
                count = 0;

                for (int j=0; j<array.length; j++) {
                    if (n == array[j]) {
                        count++;
                    }
                }

                if (count == 1) {
                    if (flag1) {
                        num1[0] = n;
                        flag1 = false;
                    } else {
                        num2[0] = n;
                        flag2 = false;
                    }
                }

            }
        }

    }

}


package nowcoder.offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {

    // 时间复杂度为 n
    // 初始化一个 candidate, count = 1; 如果遍历的值不等于 candidate count--;
    // 如果等于 cont++, 由于要寻找超过半数, 所以半数的 candidate > 0
    public int MoreThanHalfNum_Solution(int [] array) {
        int candidate = array[0], count = 1;

        for (int i=0; i<array.length; i++) {
            count = array[i]==candidate ? count+1 : count-1;
            if (count == 0) {
                candidate = array[i];
                count = 1;
            }
        }

        count = 0;
        for (int num: array) {
            if (num == candidate) {
                count++;
            }
        }

        return count>array.length/2 ? candidate : 0;

    }

}

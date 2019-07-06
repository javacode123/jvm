package nowcoder.offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        new ReOrderArray().reOrderArray(a);

        for (int num: a) {
            System.out.println(num);
        }

    }

    public void reOrderArray(int [] array) {

        // 统计基数个数
        int count = 0;
        for (int num: array) {
            if (num % 2 != 0) {
                count++;
            }
        }

        int[] temp = array.clone();
        int index = 0;

        for (int i=0; i<array.length; i++) {
            if (temp[i] % 2 ==0) {
                array[count++] = temp[i];
            } else {
                array[index++] = temp[i];
            }
        }

    }

}

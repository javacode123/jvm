package sort;

/**
 * 冒泡排序：
 *  进行 n-1 趟排序，每一趟产生一个最小值，即亮亮比较，当有一趟不需要交换时，则跳出
 */
public class bubulSort {

    public static void main(String[] args) {
        int arr[] = new int[]{0,13,5,3,1,0,30};
        sort(arr);
        show(arr);
    }

    public static void show(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    // 冒泡排序
    public static void sort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) { // 比较 n-1 次
            boolean flag = true;
            for (int j=arr.length-1; j>i; j--) {
                if (arr[j] < arr[j-1]) {// 交换
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
            if (flag)
                break;
        }
    }

}

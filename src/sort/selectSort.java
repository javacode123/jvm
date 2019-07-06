package sort;

/**
 * 选择排序，每次选择出最下的一个，与冒泡排序的区别是交换次数少，但是需要 n-1 趟选择
 */
public class selectSort {

    public static void main(String[] args) {
        int arr[] = new int[]{13,5,3,1,0,6,7,8,4,-1};
        sort(arr);
        show(arr);
    }

    public static void show(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    // 选择排序
    public static void sort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) { // n-1次选择
            int min = i;
            for (int j=i; j<arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }


}

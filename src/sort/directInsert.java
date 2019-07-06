package sort;

/**
 * 直接插入排序：
 * 时间复杂度 n 的平方, 空间复杂度 1
 */
public class directInsert {

    public static void main(String[] args) {
        int arr[] = new int[]{13,5,3,1,0};
        sort(arr);
        show(arr);
    }

    public static void show(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    // 直接插入排序
    public static void sort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            if (arr[i-1] > arr[i]) {
                int j = i-1, temp = arr[i];
                for ( ; j>=0 && arr[j]>temp; j--) {
                    arr[j+1] = arr[j];
                }
                arr[j+1] = temp;
            }
        }
    }

}

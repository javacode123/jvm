package sort;

/**
 * 希尔排序：去间隔 d 用来插入，这样随着间隔减少，序列逐渐有序，最终 d 为1时，元素基本上都已经有序，不稳定排序方法
 */
public class shellSort {

    public static void main(String[] args) {
        int arr[] = new int[]{13,5,3,1,0,30};
        sort(arr);
        show(arr);
    }

    public static void show(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    // 希尔排序
    public static void sort(int[] arr) {
        for (int d=arr.length/2; d>=1; d=d/2) {
            for (int i=d; i<arr.length; i++) {
                if (arr[i-d] > arr[i]) {
                    int j = i-d, temp = arr[i];
                    for ( ; j>=0 && arr[j]>temp; j=j-d) {
                        arr[j+d] = arr[j];
                    }
                    arr[j+d] = temp;
                }
            }
        }
    }

}

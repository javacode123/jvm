package sort;

/**
 * 快速排序：使用分治的思想，将数据按照某一元素分出左右两列，每次确定一个元素位置，不稳定
 * 时间负责度和空间复杂度相同 nlog2^n
 */
public class quickSort {

    public static void main(String[] args) {
        int arr[] = new int[]{4,13,5,3,1,0,30,99,8,7,5,1,8};
        sort(arr, 0, arr.length-1);
        show(arr);
    }

    public static void show(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    // 分出两个子表
    public static int partition(int[] arr, int low, int high) {
        int temp = arr[low];

        while (low < high) {
            while (arr[high]>=temp && low<high)
                high--;
            arr[low] = arr[high];
            while (arr[low]<=temp && low<high)
                low++;
            arr[high] = arr[low];
        }

        arr[high] = temp;

        return low;
    }

    // 快速排序
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high); // 分为两个子表
           // System.out.println(p);
            sort(arr, low, p-1);
            sort(arr, p+1, high);
        }
    }

}

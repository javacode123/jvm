package sort;

public class QuickSortImpl {

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

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partion(arr, start, end);
            sort(arr, start, p-1);
            sort(arr, p+1, end);
        }
    }

    public static int partion(int[] arr, int low, int high) {
        int temp = arr[low];

        while (low < high) {
            while (arr[high] >= temp && low < high)
                high--;
            arr[low] = arr[high];
            while (arr[low] < temp && low < high)
                low++;
            arr[high] = arr[low];
        }

        arr[low] = temp;
        return low;
    }

}

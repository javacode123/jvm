package sort;

/**
 * 堆排序，利用完全二叉树的性质，将序列变成堆，即第 k 个节点的值大于 2*k, 2*(k+1) 的值
 * 然后依次将堆顶元素放到堆尾，重新进行堆排序，等到排序的序列
 * 堆排序时间空间复杂度都是 nlog2^n
 */
public class heapSort {

    public static void main(String[] args) {
        int arr[] = new int[]{13,5,3,1,0,5,6,7,8,-1};
        creatHeap(arr);
        heapSort(arr, arr.length);
        show(arr);
    }

    public static void show(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    // 建立堆，从 n/2 开始向上回溯建立堆
    public static void creatHeap(int[] arr) {
        int k = arr.length/2-1; // 下标

        for (int i=k; i>0; i--) {
            adjustDown(arr, i, arr.length);
        }

    }

    public static void adjustDown(int[] arr, int k, int len, int xx) {
        // k 是下标
        int temp = arr[k], i = 2*k+1;
        for ( ; i<len; i=i*k+1) {
            if ((i+1<len) && arr[i] < arr[i+1]) {
                i++;
            }
            if (arr[i] < temp) {
                break;
            }
            arr[k] = arr[i];
            k = i;
        }
        arr[k] = temp;
    }

    // 向下调整堆
    public static void adjustDown(int[] arr, int k, int len) {
        int temp = arr[k], i = 2*k+1;

        for (; i<len; i=i*2+1) {
            if ((i+1)<len && arr[i+1]>arr[i]) {
                i++;
            }
            if (temp > arr[i])
                break;
            arr[k] = arr[i];
            k = i;
        }

        arr[k] = temp;
    }

    // 对堆进行排序
    public static void heapSort(int[] arr, int len) {
        // 堆顶移动到堆尾，重拍堆
        int temp;
        for (int i=len-1; i>0; i--) { // n-1 次调整
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //System.out.println("before");
            //show(arr);
            adjustDown(arr, 0, i);
            //System.out.println("after");
            //show(arr);
        }
    }

}

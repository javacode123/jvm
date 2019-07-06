package nowcoder.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfKImpl {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,4,4,4,4};
        System.out.print(new GetNumberOfKImpl().GetNumberOfK(a, 1));
    }

    public int GetNumberOfK(int [] array , int k) {
        int count = 0, l = 0, h = array.length-1, mid = 0;

        while (l <= h) {
            mid = (l+h)/2;
            if (array[mid] == k) {
                count++;
                break;
            }
            if (array[mid] > k) {
                h = mid-1;
            }
            if (array[mid] < k) {
                l = mid+1;
            }
        }

        if (count > 0) {
          l = mid-1;
          h = mid+1;
          while (l>=0 && array[l--] == k) {
              count++;
          }
            while (h<array.length && array[h++] == k) {
                count++;
            }
        } else {
            return 0;
        }

        return count;

    }

}

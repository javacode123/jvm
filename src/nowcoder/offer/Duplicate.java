package nowcoder.offer;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Duplicate {

    public static void main(String[] args) {
        int[] a = {2,3,1,0,2,5,3}, d = new int[5];
        new Duplicate().duplicate(a, a.length, d);
    }

    // 优化算法, 空间复杂度 1 时间复杂度 n
    // 思路：数组中数字范围是 0-n-1, 我们把数字放到对应的下标中, 如果对应的下标已经有值, 重复
    public boolean duplicate(int numbers[],int length,int [] duplication) {

        if (numbers==null || numbers.length==0) {
            return false;
        }

        for (int i=0; i<length; i++) {
            // 是否需要替换
            while (numbers[i] != i) {
                // 要替换位置的值是否重复
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }

        return false;

    }

    public void swap(int[] numbers, int l, int r) {
        int t = numbers[l];
        numbers[l] = numbers[r];
        numbers[r] = t;
    }


    // 空间复杂度 n 时间复杂度 n
    public boolean oldduplicate(int numbers[],int length,int [] duplication) {

        if (numbers==null || numbers.length==0) {
            duplication[0] = -1;
            return false;
        }

        int[] hash = new int[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            if (hash[numbers[i]] == 1) {
                duplication[0] = numbers[i];
                return true;
            } else {
                hash[numbers[i]] += 1;
            }
        }

        return false;

    }

}

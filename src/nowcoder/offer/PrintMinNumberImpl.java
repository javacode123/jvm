package nowcoder.offer;

import java.util.Arrays;
import java.lang.Comparable;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumberImpl {

    // 思路: 将数字转换为 string, 按照 str+str2 和 str2+str1 最小的排序
    public String PrintMinNumber(int [] numbers) {
        StringBuilder sb = new StringBuilder();

        if (numbers == null || numbers.length == 0) {
            return sb.toString();
        }

        String[] nums = new String[numbers.length];

        for (int i=0; i<nums.length; i++) {
            nums[i] = numbers[i]+"";
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        for (String str : nums)
            sb.append(str);

        return sb.toString();
    }

}

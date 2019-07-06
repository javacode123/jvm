package nowcoder.offer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class FindInArr {

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,8}, {2,4,6,10}, {3,5,8,12}};
        System.out.println(new FindInArr().Find(1, arr));
    }

    // 从左下角开始寻找
    public boolean Find(int target, int [][] array) {

        int rows = array.length, cols = array[0].length, i = rows-1, j = 0;

        while (i>=0 && j<cols) {
            if (array[i][j] > target) {
                i--;
            } else {
                if (array[i][j] < target) {
                    j++;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

}

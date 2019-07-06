package nowcoder.offer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(4, 3, 3));
    }

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visitied = new boolean[rows][cols];
        return countStep(threshold, rows, cols, visitied, 0, 0);
    }

    public int countStep(int threshold, int rows, int cols, boolean[][] visited,
                         int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || bitSum(i, j, threshold)
                || visited[i][j])
            return 0;
        visited[i][j] = true;
        return countStep(threshold, rows, cols, visited, i+1, j) +
                countStep(threshold, rows, cols, visited, i-1, j) +
                countStep(threshold, rows, cols, visited, i, j+1) +
                countStep(threshold, rows, cols, visited, i, j-1) + 1;
    }

    public boolean bitSum(int i, int j, int threshold) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i/10;
        }
        while (j != 0) {
            sum += j % 10;
            j = j/10;
        }
        return sum > threshold ? true : false;
    }

}

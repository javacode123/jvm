package nowcoder.offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，
 * 向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */
public class HasPath {

    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'},
                str = {'a', 'b', 'c', 'b'};
        System.out.println(new HasPath().hasPath(matrix, 3, 4, str));
    }

    // 回溯法
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visitied = new boolean[matrix.length];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (backTracking(matrix, rows, cols, i, j, str, visitied, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backTracking(char[] matrix, int rows, int cols, int i, int j,
                                char[] str, boolean[] visitied, int len) {
        if (len == str.length)
            return true;
        int index = i*cols+j;
        if (i < 0 || i>=rows || j < 0 || j >= cols || matrix[index] != str[len]
                || visitied[index])
            return false;
        visitied[index] = true;
        if (backTracking(matrix, rows, cols, i+1, j, str, visitied, len+1)
                || backTracking(matrix, rows, cols, i, j+1, str, visitied, len+1)
                || backTracking(matrix, rows, cols, i-1, j, str, visitied, len+1)
                || backTracking(matrix, rows, cols, i, j-1, str, visitied, len+1))
            return true;
        visitied[index] = false;
        return false;
    }


}

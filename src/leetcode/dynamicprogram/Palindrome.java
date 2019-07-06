package leetcode.dynamicprogram;

/**
 * @author zjl
 * 求 String 最长回文子序列
 */
public class Palindrome {

    public static void main(String[] ars) {
        System.out.println(lcs("cabbeafc"));
    }

    // dp[i][j] 表示str[i...j]的回文子序列长度
    // 对于 str[i...j] 如果 r[i]==r[j] dp[i][j] = dp[i-1][j-1] + 2
    // 如果 r[i]!=r[j] dp[i][j] = max(dp[i+1][j], dp[i][j-1])
    // 需要计算 dp[i+1][*] dp[*][j-1] 所以 i 从大到小计算，j 从小到大计算
    public static int lcs(String str) {
        int dp[][] = new int[str.length()][str.length()];
        int r[][] = new int[str.length()][str.length()];

        for (int i=0; i<str.length(); i++) {
            for (int j=0; j<str.length(); j++) {
                if (i==j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        // i 应该从大到小，j 应该从小到大
        for (int i=str.length()-1; i>=0; i--) {
            for (int j=i+1; j<str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                    r[i][j] = 3;
                } else {
                    if (dp[i+1][j]>dp[i][j-1]) {
                        dp[i][j] = dp[i+1][j];
                        r[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j-1];
                        r[i][j] = 2;
                    }
                    //dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // 遍历列
        for (int j=str.length()-1; j>=0; j--) {
            for (int i=0; i<str.length(); i++) {
               if (r[i][j] == 3) {
                   sb.append(str.charAt(j));
               }
            }
        }

        System.out.print(sb.toString() + sb.reverse());

        return dp[0][str.length()-1];
    }

}

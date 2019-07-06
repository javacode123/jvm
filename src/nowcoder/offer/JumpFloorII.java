package nowcoder.offer;

import java.util.Arrays;

public class JumpFloorII {

    public int JumpFloorII(int target){

        int[] dp = new int[target];
        Arrays.fill(dp, 1);

        for (int i=1; i<target; i++) {
            for (int j=0; j<i; j++) {
                dp[i] += dp[j];
            }
        }

        return dp[target-1];

    }

}

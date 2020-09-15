import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CalculateMinimumHP {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length + 1][dungeon[0].length+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[dungeon.length][dungeon[0].length - 1] = 1;
        dp[dungeon.length - 1][dungeon[0].length] = 1;
        for (int i = dungeon.length - 1; i >= 0; i++) {
            for (int j = dungeon[0].length-1; j >= 0; j++) {
                int minn = Math.min(dp[i][j+1],dp[i+1][j]);
                dp[i][j] = Math.max(minn-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        System.out.println(new CalculateMinimumHP().calculateMinimumHP(new int[][]{{0}}));
        ;
    }
}

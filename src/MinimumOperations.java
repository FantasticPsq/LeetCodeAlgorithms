public class MinimumOperations {
    public int minimumOperations(String leaves) {
        int[][] dp = new int[leaves.length()][3];
        dp[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        dp[1][0] = dp[1][2] = dp[2][1] = Integer.MAX_VALUE;
        for (int i = 1; i < leaves.length(); i++) {
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            dp[i][0] = dp[i-1][0]+isYellow;
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1])+isRed;
            if(i>=2){
                dp[i][2] = Math.min(dp[i-1][2],dp[i-1][1])+isYellow;
            }
        }
        return dp[leaves.length()-1][2];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumOperations().minimumOperations("yry"));
    }
}

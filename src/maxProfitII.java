public class maxProfitII {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i-1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i-1]);
        }
        return dp[prices.length][0];
    }

    public static void main(String[] args) {
        System.out.println(new maxProfitII().maxProfit(new int[]{1,2,3,4,5}));
    }
}

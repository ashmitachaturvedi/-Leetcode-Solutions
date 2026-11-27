
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] free = new int[n];
        int minPrice = Integer.MAX_VALUE;

        // Calculate free items for each item
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);

            for (int j = 0; j < n; j++) {
                if (i != j &&
                    items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }

        int[][] dp = new int[n + 1][budget + 1];

        for (int i = 1; i <= n; i++) {
            int price = items[i - 1][1];
            int gain = free[i - 1] + 1;

            for (int b = 0; b <= budget; b++) {

                // Don't buy this item
                dp[i][b] = dp[i - 1][b];

                if (b >= price) {

                    // Buy first copy of this item
                    dp[i][b] = Math.max(
                        dp[i][b],
                        dp[i - 1][b - price] + gain
                    );

                    // Buy additional copies
                    dp[i][b] = Math.max(
                        dp[i][b],
                        dp[i][b - price] + 1
                    );
                }
            }
        }

        return dp[n][budget];
    }
}

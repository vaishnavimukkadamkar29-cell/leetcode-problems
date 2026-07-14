class Solution {
    public int subsequencePairCount(int[] nums) {
        final int MOD = 1_000_000_007;
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        // dp[x][y] stores the number of pairs with GCD x and GCD y
        int[][] dp = new int[maxNum + 1][maxNum + 1];
        dp[0][0] = 1; // Base case: both subsequences are empty

        for (int num : nums) {
            int[][] nextDp = new int[maxNum + 1][maxNum + 1];
            
            for (int x = 0; x <= maxNum; x++) {
                for (int y = 0; y <= maxNum; y++) {
                    if (dp[x][y] == 0) continue;

                    long currentWays = dp[x][y];

                    // Option 1: Skip num
                    nextDp[x][y] = (int) ((nextDp[x][y] + currentWays) % MOD);

                    // Option 2: Add num to the first subsequence
                    int nextX = gcd(x, num);
                    nextDp[nextX][y] = (int) ((nextDp[nextX][y] + currentWays) % MOD);

                    // Option 3: Add num to the second subsequence
                    int nextY = gcd(y, num);
                    nextDp[x][nextY] = (int) ((nextDp[x][nextY] + currentWays) % MOD);
                }
            }
            dp = nextDp;
        }

        long totalPairs = 0;
        // Sum up all pairs where x == y and x > 0 (subsequences must be non-empty)
        for (int g = 1; g <= maxNum; g++) {
            totalPairs = (totalPairs + dp[g][g]) % MOD;
        }

        return (int) totalPairs;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

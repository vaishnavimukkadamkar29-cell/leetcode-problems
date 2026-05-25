class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        // If the last character is '1', we can never land on it
        if (s.charAt(n - 1) == '1') {
            return false;
        }

        // dp[i] will store whether index i is reachable from index 0
        boolean[] dp = new boolean[n];
        dp[0] = true; // Base case: starting point is always reachable

        // activeJumps tracks how many reachable indices can currently jump to index i
        int activeJumps = 0;

        for (int i = 1; i < n; i++) {
            // 1. Add the newly available index to the sliding window
            if (i >= minJump) {
                if (dp[i - minJump]) {
                    activeJumps++;
                }
            }

            // 2. Remove the index that just fell out of the maxJump boundary
            if (i > maxJump) {
                if (dp[i - maxJump - 1]) {
                    activeJumps--;
                }
            }

            // 3. Current position is reachable if it's a '0' and there's an active jump option
            if (s.charAt(i) == '0' && activeJumps > 0) {
                dp[i] = true;
            }
        }

        // Return if the last index is reachable
        return dp[n - 1];
        
    }
}
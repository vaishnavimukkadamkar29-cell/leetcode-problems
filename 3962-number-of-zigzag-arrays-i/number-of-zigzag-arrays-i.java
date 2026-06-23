class Solution {
    public int zigZagArrays(int n, int l, int r) {
         int MOD = 1_000_000_007;
        int m = r - l + 1;

        // Base cases
        if (n == 1) {
            return m;
        }
        if (n == 2) {
            // For length 2, any pair of distinct elements is valid
            long ans = ((long) m * (m - 1)) % MOD;
            return (int) ans;
        }

        // up[v] stores count of sequences ending at v with an 'up' transition
        // down[v] stores count of sequences ending at v with a 'down' transition
        long[] up = new long[m];
        long[] down = new long[m];

        // Initialize for length 2: 
        // For a fixed ending value v, the number of strictly smaller values is v
        // The number of strictly larger values is (m - 1 - v)
        for (int v = 0; v < m; v++) {
            up[v] = v;             // count of u < v
            down[v] = m - 1 - v;   // count of u > v
        }

        // Transition from length 3 up to n
        for (int i = 3; i <= n; i++) {
            long[] nextUp = new long[m];
            long[] nextDown = new long[m];

            // Compute prefix sums of down[] for O(1) nextUp transitions
            // nextUp[u] = sum_{v < u} down[v]
            long currentPrefixSum = 0;
            for (int u = 0; u < m; u++) {
                nextUp[u] = currentPrefixSum;
                currentPrefixSum = (currentPrefixSum + down[u]) % MOD;
            }

            // Compute suffix sums of up[] for O(1) nextDown transitions
            // nextDown[u] = sum_{v > u} up[v]
            long currentSuffixSum = 0;
            for (int u = m - 1; u >= 0; u--) {
                nextDown[u] = currentSuffixSum;
                currentSuffixSum = (currentSuffixSum + up[u]) % MOD;
            }

            up = nextUp;
            down = nextDown;
        }

        // Sum up all valid sequences of length n
        long totalValidArrays = 0;
        for (int v = 0; v < m; v++) {
            totalValidArrays = (totalValidArrays + up[v] + down[v]) % MOD;
        }

        return (int) totalValidArrays;
        
    }
}
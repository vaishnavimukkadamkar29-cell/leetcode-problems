class Solution {
    public int maxJumps(int[] arr, int d) {
         int n = arr.length;
        int[] memo = new int[n];
        int maxVisited = 0;
        
        // Find the maximum path starting from any index
        for (int i = 0; i < n; i++) {
            maxVisited = Math.max(maxVisited, dfs(arr, d, i, memo));
        }
        
        return maxVisited;
    }
    
    private int dfs(int[] arr, int d, int i, int[] memo) {
        // Return cached result if already calculated
        if (memo[i] != 0) {
            return memo[i];
        }
        
        int maxFromHere = 1; // Current index itself counts as 1 visited index
        int n = arr.length;
        
        // 1. Explore valid jumps to the right
        for (int j = i + 1; j <= Math.min(i + d, n - 1); j++) {
            // Stop immediately if blocked by an equal or taller building
            if (arr[j] >= arr[i]) {
                break;
            }
            maxFromHere = Math.max(maxFromHere, 1 + dfs(arr, d, j, memo));
        }
        
        // 2. Explore valid jumps to the left
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            // Stop immediately if blocked by an equal or taller building
            if (arr[j] >= arr[i]) {
                break;
            }
            maxFromHere = Math.max(maxFromHere, 1 + dfs(arr, d, j, memo));
        }
        
        // Cache and return the result
        memo[i] = maxFromHere;
        return maxFromHere;
        
    }
}
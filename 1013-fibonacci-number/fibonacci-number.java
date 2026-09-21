class Solution {
    public int fib(int n) {
        // 1. Create a memoization array to store already calculated results
        // n + 1 size handles indices from 0 up to n
        int[] memo = new int[n + 1]; 
        
        return helper(n, memo);
    }
    
    private int helper(int n, int[] memo) {
        // Base Cases
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // 2. If we have already calculated fib(n), return it from memory!
        if (memo[n] != 0) {
            return memo[n];
        }
        
        // 3. Otherwise, calculate it once and store it in our memo array
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        
        return memo[n];
    }
}

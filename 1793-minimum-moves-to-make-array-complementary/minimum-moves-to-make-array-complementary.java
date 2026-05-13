class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        // Difference array to track change in moves for each possible sum
        // Possible sums range from 2 to 2 * limit
        int[] delta = new int[2 * limit + 2];
        
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            
            // Scenario 1: Zero moves needed
            int targetSum = a + b;
            
            // Scenario 2: One move min and max bounds
            int minPossibleSumWithOneMove = Math.min(a, b) + 1;
            int maxPossibleSumWithOneMove = Math.max(a, b) + limit;
            
            // Apply intervals to the difference array
            // Default is 2 moves for all sums [2, 2 * limit]
            delta[2] += 2; 
            
            // Reduce to 1 move for interval [minPossibleSumWithOneMove, maxPossibleSumWithOneMove]
            delta[minPossibleSumWithOneMove] -= 1;
            
            // Reduce to 0 moves for exactly targetSum
            delta[targetSum] -= 1;
            delta[targetSum + 1] += 1;
            
            // Revert back to 2 moves after maxPossibleSumWithOneMove
            delta[maxPossibleSumWithOneMove + 1] += 1;
        }
        
        int minMoves = Integer.MAX_VALUE;
        int currentMoves = 0;
        
        // Find the sum that results in the minimum total moves
        for (int sum = 2; sum <= 2 * limit; sum++) {
            currentMoves += delta[sum];
            minMoves = Math.min(minMoves, currentMoves);
        }
        
        return minMoves;
    }
}
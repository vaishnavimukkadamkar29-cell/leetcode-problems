class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        
        int totalCost = 0;
        int n = cost.length;
        
        // Step 2: Iterate backwards from the most expensive candies
        // We pick 3 candies at a time (index i, i-1, and i-2)
        for (int i = n - 1; i >= 0; i -= 3) {
            // Add the price of the most expensive candy in the triplet
            totalCost += cost[i]; 
            
            // Add the price of the second most expensive candy (if it exists)
            if (i - 1 >= 0) {
                totalCost += cost[i - 1];
            }
            
            // The third candy (at index i - 2) is free, so we skip it!
        }
        
        return totalCost;
        
    }
}
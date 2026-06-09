class Solution {
    public long maxTotalValue(int[] nums, int k) {
         int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;
        
        // Find global maximum and minimum elements
        for (int num : nums) {
            if (num > maxElement) {
                maxElement = num;
            }
            if (num < minElement) {
                minElement = num;
            }
        }
        
        // Cast to long before multiplying to prevent integer overflow
        long maxSubarrayValue = (long) maxElement - minElement;
        return maxSubarrayValue * k;
        

        
    }
}
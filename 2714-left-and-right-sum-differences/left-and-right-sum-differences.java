class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Step 1: Calculate the total sum of the entire array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Step 2: Track the left sum dynamically while computing the right sum
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            // Right sum for index i is: totalSum - leftSum - nums[i]
            int rightSum = totalSum - leftSum - nums[i];
            
            // Store the absolute difference
            answer[i] = Math.abs(leftSum - rightSum);
            
            // Update leftSum to include the current element for the next iteration
            leftSum += nums[i];
        }
        
        return answer;
        
    }
}
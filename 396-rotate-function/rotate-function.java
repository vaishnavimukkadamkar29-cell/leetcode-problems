class Solution {
    public int maxRotateFunction(int[] nums) {
         int n = nums.length;
        int sum = 0;
        int f = 0;

        // 1. Compute the base cases: total array sum and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }

        int maxVal = f;

        // 2. Derive F(i) from F(i-1) in O(1) time
        for (int i = n - 1; i > 0; i--) {
            f = f + sum - n * nums[i];
            maxVal = Math.max(maxVal, f);
        }

        return maxVal;
        
    }
}
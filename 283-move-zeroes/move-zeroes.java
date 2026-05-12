class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0; // Start both at 0 to handle n=1 safely

        while (right < n) {
            // Case 1: Found a non-zero to move to the 'left' spot
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            } 
            // Case 2: Found a zero, just keep moving 'right' to find a non-zero
            else {
                right++;
            }
        }
        
    }
}
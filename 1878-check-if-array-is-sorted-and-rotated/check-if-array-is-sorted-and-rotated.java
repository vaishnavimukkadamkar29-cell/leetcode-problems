class Solution {
    public boolean check(int[] nums) {
        int countDrops = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Check if current element is greater than the next element
            // (i + 1) % n seamlessly connects the last element back to the first element
            if (nums[i] > nums[(i + 1) % n]) {
                countDrops++;
            }
            
            // Optimization: If drops exceed 1, it's already invalid
            if (countDrops > 1) {
                return false;
            }
        }
        
        return true;
    }
}
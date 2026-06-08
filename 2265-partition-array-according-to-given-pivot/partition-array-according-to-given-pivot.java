class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
         int n = nums.length;
        int[] result = new int[n];
        int index = 0;
        
        // Step 1: Collect all elements smaller than the pivot
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                result[index++] = nums[i];
            }
        }
        
        // Step 2: Collect all elements equal to the pivot
        for (int i = 0; i < n; i++) {
            if (nums[i] == pivot) {
                result[index++] = nums[i];
            }
        }
        
        // Step 3: Collect all elements greater than the pivot
        for (int i = 0; i < n; i++) {
            if (nums[i] > pivot) {
                result[index++] = nums[i];
            }
        }
        
        return result;
    }
}
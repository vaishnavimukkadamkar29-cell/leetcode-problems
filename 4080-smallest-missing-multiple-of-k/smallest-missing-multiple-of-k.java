import java.util.Arrays;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        // 1. Sort the array so we can check numbers in order
        Arrays.sort(nums);
        
        int targetMultiple = k;
        
        // 2. Scan through the sorted array
        for (int num : nums) {
            // If we find our target multiple, move to the next multiple
            if (num == targetMultiple) {
                targetMultiple += k;
            }
            // Optimization: If the array number is already bigger than our target,
            // it means the target multiple was completely skipped/missing!
            else if (num > targetMultiple) {
                return targetMultiple;
            }
        }
        
        return targetMultiple;
    }
}

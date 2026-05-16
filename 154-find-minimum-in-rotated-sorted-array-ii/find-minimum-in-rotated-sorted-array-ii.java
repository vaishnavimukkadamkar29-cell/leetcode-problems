class Solution {
    public int findMin(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    
    while (low < high) {
        int mid = low + (high - low) / 2;
        
        if (nums[mid] < nums[high]) {
            // The minimum is in the left half (including mid)
            high = mid;
        } else if (nums[mid] > nums[high]) {
            // The minimum is in the right half (excluding mid)
            low = mid + 1;
        } else {
            // Duplicates found: nums[mid] == nums[high]
            // Safely shrink the search space from the right
            high--;
        }
    }
    return nums[low];
}


        
    }

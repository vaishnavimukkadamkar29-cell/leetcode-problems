class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        
        // The prefix sum can range from -n to +n.
        // To handle negative indices, we shift everything by offset = n + 1.
        int offset = n + 1;
        int maxTreeSize = 2 * n + 5;
        int[] bit = new int[maxTreeSize];
        
        // Helper function to update Fenwick Tree
        // Adds val to the element at index idx
        Runnable1 update = (idx, val) -> {
            while (idx < maxTreeSize) {
                bit[idx] += val;
                idx += idx & (-idx);
            }
        };
        
        // Helper function to query Fenwick Tree
        // Returns the sum from index 1 to idx
        java.util.function.Function<Integer, Integer> query = (idx) -> {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & (-idx);
            }
            return sum;
        };
        
        // Initially, the prefix sum before starting the array is 0.
        // Its shifted index in the BIT is 0 + offset.
        // We register this initial prefix sum with a count of 1.
        int initialIdx = 0 + offset;
        int tempIdx = initialIdx;
        while (tempIdx < maxTreeSize) {
            bit[tempIdx] += 1;
            tempIdx += tempIdx & (-tempIdx);
        }
        
        int currentPrefixSum = 0;
        int resultCount = 0;
        
        for (int num : nums) {
            // Transform value: target becomes +1, others become -1
            if (num == target) {
                currentPrefixSum += 1;
            } else {
                currentPrefixSum -= 1;
            }
            
            // We need previous prefix sums that are strictly less than currentPrefixSum.
            // In terms of BIT indexing: strict inequality means querying up to (currentPrefixSum + offset - 1).
            int queryLimitIdx = currentPrefixSum + offset - 1;
            
            // Query the count of valid previous prefix sums
            int validCount = 0;
            int tIdx = queryLimitIdx;
            while (tIdx > 0) {
                validCount += bit[tIdx];
                tIdx -= tIdx & (-tIdx);
            }
            
            resultCount += validCount;
            
            // Insert the new prefix sum into the BIT
            int insertIdx = currentPrefixSum + offset;
            while (insertIdx < maxTreeSize) {
                bit[insertIdx] += 1;
                insertIdx += insertIdx & (-insertIdx);
            }
        }
        
        return resultCount;
    }
    
    // Functional interface to bypass local primitive scope limitations in Java 8+
    @FunctionalInterface
    interface Runnable1 {
        void run(int idx, int val);
    }
}

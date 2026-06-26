class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        
        // The prefix sum can range from -n to +n. 
        // We shift indices by (n + 1) so everything stays positive (1 to 2n+1).
        int offset = n + 1;
        int[] bit = new int[2 * n + 5]; // Binary Indexed Tree array
        
        int prefixSum = 0;
        long ans = 0;
        
        // Insert the initial prefix sum of 0 (with offset) into the BIT
        update(bit, 0 + offset, 1);
        
        for (int x : nums) {
            // Step 1: Transform (+1 for target, -1 for anything else)
            if (x == target) {
                prefixSum += 1;
            } else {
                prefixSum -= 1;
            }
            
            // Step 2: Query the BIT to count how many previous prefix sums 
            // are strictly less than the current prefixSum
            ans += query(bit, prefixSum + offset - 1);
            
            // Step 3: Insert the current prefixSum into the BIT
            update(bit, prefixSum + offset, 1);
        }
        
        return ans;
    }
    
    // Standard BIT/Fenwick Tree Update Function
    private void update(int[] bit, int idx, int val) {
        for (; idx < bit.length; idx += idx & -idx) {
            bit[idx] += val;
        }
    }
    
    // Standard BIT/Fenwick Tree Query Function
    private int query(int[] bit, int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx) {
            sum += bit[idx];
        }
        return sum;
    }
}

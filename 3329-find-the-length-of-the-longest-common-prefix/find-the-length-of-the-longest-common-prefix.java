class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
         HashSet<Integer> prefixes = new HashSet<>();
        
        // Step 1: Extract all possible prefixes from arr1
        for (int val : arr1) {
            while (val > 0) {
                prefixes.add(val);
                val /= 10; // Remove the last digit to get the next prefix
            }
        }
        
        int maxLength = 0;
        
        // Step 2: Check prefixes of arr2 against the HashSet
        for (int val : arr2) {
            while (val > 0) {
                if (prefixes.contains(val)) {
                    // Calculate digit length of the matching prefix
                    int currentLength = String.valueOf(val).length();
                    maxLength = Math.max(maxLength, currentLength);
                    break; // Smaller prefixes of this number won't beat the current match
                }
                val /= 10;
            }
        }
        
        return maxLength;
    }
        
    }

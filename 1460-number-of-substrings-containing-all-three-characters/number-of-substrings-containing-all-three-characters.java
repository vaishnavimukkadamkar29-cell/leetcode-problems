
        class Solution {
    public int numberOfSubstrings(String s) {
        // Track the last seen index of 'a', 'b', and 'c'
        int[] lastSeen = {-1, -1, -1};
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Update the index for the current character
            lastSeen[s.charAt(i) - 'a'] = i;
            
            // If all characters have been seen at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                // Find the smallest index among 'a', 'b', and 'c'
                int minIndex = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                // Every substring starting from index 0 up to minIndex is valid
                count += minIndex + 1;
            }
        }
        
        return count;
    }
}

        

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        // Edge case: empty needle
        if (m == 0) return 0;
        
        // Step 1: Pre-calculate the LPS array for the needle
        int[] lps = computeLPSArray(needle);
        
        int i = 0; // Pointer for haystack
        int j = 0; // Pointer for needle
        
        // Step 2: Traverse the haystack
        while (i < n) {
            // If characters match, move both pointers forward
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            
            // If the whole needle is successfully matched
            if (j == m) {
                return i - m; // Return the starting index of the match
            }
            
            // If there is a mismatch after matching some characters
            else if (i < n && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    // Smart skip: update needle pointer using the LPS table
                    j = lps[j - 1];
                } else {
                    // If no characters matched yet, simply move haystack pointer forward
                    i++;
                }
            }
        }
        
        return -1; // Needle not found
    }
    
    // Helper function to build the LPS array
    private int[] computeLPSArray(String needle) {
        int m = needle.length();
        int[] lps = new int[m];
        
        int len = 0; // Length of the previous longest prefix-suffix
        int i = 1;   // lps[0] is always 0, so start calculating from index 1
        
        while (i < m) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // Fall back to the previous known prefix match
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}

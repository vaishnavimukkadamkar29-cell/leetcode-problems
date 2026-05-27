class Solution {
    public int numberOfSpecialChars(String word) {
        int[] status = new int[26];
        
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                int idx = c - 'a';
                if (status[idx] == 0) {
                    status[idx] = 1; // First time seeing lowercase
                } else if (status[idx] == 2) {
                    status[idx] = -1; // Lowercase appeared AFTER uppercase; permanently invalidate
                }
            } else {
                int idx = c - 'A';
                if (status[idx] == 1) {
                    status[idx] = 2; // Uppercase appeared AFTER lowercase; valid special character state
                } else if (status[idx] == 0) {
                    status[idx] = -1; // Uppercase appeared BEFORE lowercase; permanently invalidate
                }
            }
        }
        
        // Count how many characters finished in state 2
        int count = 0;
        for (int state : status) {
            if (state == 2) {
                count++;
            }
        }
        
        return count;
        
    }
}
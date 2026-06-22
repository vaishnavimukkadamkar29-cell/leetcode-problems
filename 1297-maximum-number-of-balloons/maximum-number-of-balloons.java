class Solution {
    public int maxNumberOfBalloons(String text) {
        // Array to store counts of 'b', 'a', 'l', 'o', 'n'
        int[] counts = new int[5];
        
        // Count frequencies of the required characters
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b': counts[0]++; break;
                case 'a': counts[1]++; break;
                case 'l': counts[2]++; break;
                case 'o': counts[3]++; break;
                case 'n': counts[4]++; break;
            }
        }
        
        // 'l' and 'o' are needed twice per word
        counts[2] /= 2; 
        counts[3] /= 2;
        
        // Find the minimum frequency among all required letters
        int min = counts[0];
        for (int i = 1; i < 5; i++) {
            if (counts[i] < min) {
                min = counts[i];
            }
        }
        
        return min;
    }
}

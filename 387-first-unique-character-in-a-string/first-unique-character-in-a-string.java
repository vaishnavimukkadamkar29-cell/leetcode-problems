class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        // Convert string to character array once to avoid function call overhead
        char[] chars = s.toCharArray(); 
        
        for (char c : chars) {
            count[c - 'a']++;
        }
        
        // Use a standard index loop to find the position
        for (int j = 0; j < chars.length; j++) {
            if (count[chars[j] - 'a'] == 1) {
                return j;
            }
        }
        
        return -1;
    }
}

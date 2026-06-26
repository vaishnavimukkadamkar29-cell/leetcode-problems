class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int maxlength=0;
        HashSet<Character> seen= new HashSet<>();
        while(right<s.length())
        {
            char nextchar=s.charAt(right);
            while(seen.contains(nextchar))
            {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(nextchar);
            int curr=right-left+1;
            maxlength=Math.max(maxlength,curr);
            right++;
        }
        
    return maxlength;
        
    }
}
class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==1)
        {
            return 1;
        }
        int[] freq = new int[128];
        for(int i =0;i<s.length();i++)
        {
            freq[s.charAt(i)]++;
        }
        int length=0;
        boolean hasOdd = false;
        for(int count:freq)
        {
            length+=(count/2)*2;
             if(count%2!=0)
        {
            hasOdd=true;
        }
            
        }
       
        if(hasOdd)
        {
            length+=1;
        }

        return length;
    }
}
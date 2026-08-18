class Solution {
    public int strStr(String haystack, String needle) {
        int p1=0;
        int p2=0;
        int small=needle.length();
        if(haystack.contains(needle))
        {
            while(p1<haystack.length())
            {
                String chunk=haystack.substring(p1,p1+small);
            if(haystack.charAt(p1)==needle.charAt(p2) && chunk.equals(needle) )
            {
                return p1;
            }
            else{
                p1++;
            }
            }

        }
        return -1;

        
    }
}
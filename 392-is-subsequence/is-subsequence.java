class Solution {
    public boolean isSubsequence(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        int n=Math.min(n1,n2);
        int p1=0;
        int p2=0;
        while(p1<n1 && p2<n2)
        {
            if(s.charAt(p1)==t.charAt(p2))
            {
                p1++;
            }
            p2++;
        }
        return p1==s.length();
        
        
    }
}
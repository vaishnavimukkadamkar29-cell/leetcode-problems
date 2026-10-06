class Solution {
    public int minAddToMakeValid(String s) {
        int opencount=0;
        int added=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                opencount++;
            }
            else{
                if(opencount>0)
                {
                    opencount--;
                }
                else{
                    added++;
                }
            }
        }
        return opencount+added;
        
    }
}
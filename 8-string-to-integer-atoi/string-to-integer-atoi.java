class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.isEmpty())
        {
            return 0;
        }
        int sign=1;
        int startindex=0;
        if(s.charAt(0)=='-')
        {
            sign=-1;
            startindex=1;
        }
        else if(s.charAt(0)=='+'){
            startindex=1;
        }
        int total=0;
        for(int i =startindex;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(!Character.isDigit(ch))
            {
                break;
            }
            int digit=ch-'0';
            if(total>Integer.MAX_VALUE/10 || (total==Integer.MAX_VALUE/10 && digit>7))
            {
                return (sign==-1)? Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            total=(total*10)+digit;
            
        }
        return total*sign;
        
        
    }
}
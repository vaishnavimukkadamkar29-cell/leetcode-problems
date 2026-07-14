class Solution {
    public long sumAndMultiply(int n) {
        String s=String.valueOf(n);
        String ans="";
        if(n==0)
        {
            return 0;
        }
        for(int i =0;i<s.length();i++)
        {
            if(s.charAt(i)!='0')
            {
                ans=ans+s.charAt(i);
            }
        }
        long x =Long.parseLong(ans);
        long sum=0;
        long temp=Math.abs((long)x);
        while(temp!=0)
        {
            long last=temp%10;
            sum=sum+last;
            temp=temp/10;
        }
        long result=x*sum;
        return result;
        
    }
}
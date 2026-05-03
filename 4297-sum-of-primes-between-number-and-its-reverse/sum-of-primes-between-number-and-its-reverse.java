import java.lang.Math;
class Solution {
    public int sumOfPrimesInRange(int n) {
        int n1=revnum(n);
        int start=Math.min(n,n1);
        int end=Math.max(n,n1);
        int sum=0;
        for(int i =start;i<=end;i++)
        {
            if(isPrime(i))
            {
                sum=sum+i;
            }
        }
        return sum;
       
       
    }
    public int revnum(int n)
    {
        int temp=n;
        int rev=0;
        while(temp!=0)
        {
            int digit=temp%10;
            rev=rev*10+digit;
            temp/=10;
        }
        return rev;
    }
    public boolean isPrime(int n)
    {
        int count=0;
        if(n<=1)
        {
            return false;
        }
        for(int i =2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
}
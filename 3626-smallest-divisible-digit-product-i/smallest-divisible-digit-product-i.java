class Solution {
    public int smallestNumber(int n, int t) {
        int ans=n;
      for(int i =n;i<=100;i++)
      {
        int temp=i;
        int product=1;
        while(temp!=0)
        {
            int last=temp%10;
            product=product*last;
            temp=temp/10;
        }
        if(product%t==0)
        {
             ans=i;
             break;
        }
        else{
            continue;
        }
      }
      return ans;
        
    }
}
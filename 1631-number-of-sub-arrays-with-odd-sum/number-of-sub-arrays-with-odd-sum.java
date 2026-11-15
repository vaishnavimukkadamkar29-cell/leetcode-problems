class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int oddcount=0;
        int evencount=1;
        int prefix=0;
        int res=0;
        int mod=1000000007;
        for(int num:arr)
        {
            prefix+=num;
            if(prefix%2==0)
            {
                res+=oddcount;
                evencount++;
            }
            else{
                res+=evencount;
                oddcount++;
            }
            res=res%mod;

        }
        return res;

    }
}
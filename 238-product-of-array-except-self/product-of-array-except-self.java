class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n =nums.length;
        int[] ans= new int[n];
        int product=1;
        int zerocount=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0)
            {
            product=product*nums[i];
            }
            else{
                zerocount++;
            }
        }
        if(zerocount>1)
        {
            for(int i=0;i<n;i++)
            {
                ans[i]=0;
            }
        }
        else if(zerocount==1)
        {
            for(int i=0;i<n;i++)
            {
                if(nums[i]==0)
                {
                    ans[i]=product;
                }
                else{
                    ans[i]=0;
                }
            }
        }
        else{
            for(int i=0;i<n;i++)
            {
                if(nums[i]!=0)
                {
                ans[i]=product/nums[i];
                }
            }
        }
        return ans;
    }
}
class Solution {
    public int findGCD(int[] nums) {
        int n=nums.length;
        int largest=0;
        for(int i =0;i<n;i++)
        {
            if(nums[i]>largest)
            {
                largest=nums[i];
            }
        }
        int smallest=nums[0];
        for(int i =0;i<n;i++)
        {
            if(nums[i]<=smallest)
            {
                smallest=nums[i];
            }
        }
        int ans=1;
        for(int i =1;i<=largest;i++)
        {
            if(smallest%i==0 && largest%i==0)
            {
                ans=i;
            }
        }
        return ans;
    }
}
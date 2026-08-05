class Solution {
    public int smallestEqual(int[] nums) {
        int n = nums.length;
        int ans=-1;
        for(int i=0;i<n;i++)
        {
            if(i%10==nums[i])
            {
                ans=i;
                break;
            }
        }
        return ans;
        
    }
}
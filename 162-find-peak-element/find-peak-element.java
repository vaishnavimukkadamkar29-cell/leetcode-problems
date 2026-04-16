class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int lo=0;
        int hi=n-1;
        while(lo<hi)
        {
            int mid=(lo+hi)/2;
            if(nums[mid]<nums[mid+1])
            {
                lo=mid+1;
            }
            else {
                hi=mid;
            }
        
        }
        return lo;
    }
}
    
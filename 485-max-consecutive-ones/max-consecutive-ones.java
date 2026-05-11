import java.lang.Math;
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count=0;
        int temp=0;
        int ans=0;
        for(int i =0;i<n;i++)
        {
            if(nums[i]==1)
            {
                count++;
            }
            else{
                count=0;
            }
           ans=Math.max(ans,count);
        }
        return ans;
    }
}
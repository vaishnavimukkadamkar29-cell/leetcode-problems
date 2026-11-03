class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int num:nums)
        {
            if(num>max)
            {
                max=num;
            }
        }
        int minmoves=0;
        for(int i=0;i<n;i++)
        {
            int reach=max-nums[i];
            minmoves+=reach;
        }
        return minmoves;


        
    }
}
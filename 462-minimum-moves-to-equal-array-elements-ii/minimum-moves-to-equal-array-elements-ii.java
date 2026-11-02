class Solution {
    public int minMoves2(int[] nums) {
       Arrays.sort(nums);
       int n=nums.length;
       int median=0;
       int minmoves=0;
       if(n%2!=0)
       {
        median=nums[n/2];
       }
       else{
       median = (nums[n/2-1]+nums[n/2])/2;
       }
       for(int num:nums)
       {
        int sum=Math.abs(num-median);
        minmoves+=sum;
       
       }
       return minmoves;





        
    }
}
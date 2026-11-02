class Solution {
    public int minMoves2(int[] nums) {
       Arrays.sort(nums);
       int n=nums.length;
       int minmoves=0;
       int i=0;
       int j=n-1;
       while(i<j)
       {  
        minmoves+=nums[j]-nums[i];
        i++;
        j--;
       }
       return minmoves;





        
    }
}
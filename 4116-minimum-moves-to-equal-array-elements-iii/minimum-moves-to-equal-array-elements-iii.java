class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
       int sum=0;
        for(int num:nums)
        {
            if(num>max)
            {
                max=num;
            }
            sum+=num;
        }
       return (n*max)-sum;


        
    }
}
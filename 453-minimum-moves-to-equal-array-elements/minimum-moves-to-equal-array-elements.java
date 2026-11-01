class Solution {
    public int minMoves(int[] nums) {
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int num:nums)
        {
            if(num<min)
            {
                min=num;
            }
        }
        int moves=0;
        for(int num:nums)
        {
            int diff=num-min;
            moves+=diff;

        }
        return moves;


        
    }
}
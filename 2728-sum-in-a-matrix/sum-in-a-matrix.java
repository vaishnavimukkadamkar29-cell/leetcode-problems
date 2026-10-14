class Solution {
    public int matrixSum(int[][] nums) {
        int rows=nums.length;
        int cols=nums[0].length;
        for(int i =0;i<rows;i++)
        {
            Arrays.sort(nums[i]);
        }
        int sum=0;
        for(int j =0;j<cols;j++)
        {
            int max=0;
            for(int i=0;i<rows;i++)
            {
                    max=Math.max(nums[i][j],max);
            }
            sum=sum+max;
        }
        return sum;
    }
}
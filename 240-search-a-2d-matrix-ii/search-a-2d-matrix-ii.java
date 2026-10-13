class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ans=false;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int row=0;
        int col=cols-1;
        while(row<rows && col>=0)
        {
            int value=matrix[row][col];
            if(value==target)
            {
                return true;
            }
            else if(value>target)
            {
                col=col-1;
            }
            else{
                row=row+1;
            }
        }
        return ans;
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        boolean[] row=new boolean[rows];
        boolean[] column =new boolean[cols];
        for(int i =0;i<rows;i++)
        {
            for(int j =0;j<cols;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i]=true;
                    column[j]=true;
                }
            }
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(row[i] || column[j])
                {
                    matrix[i][j]=0;
                }
            }
        }
        
    }
}
class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        for(int j=0;j<matrix[0].length;j++)
        {
            int maxcount=0;
            for(int i=0;i<matrix.length;i++)
            {
                if(maxcount<matrix[i][j])
                {
                    maxcount=matrix[i][j];

                }
            }
            for(int i=0;i<matrix.length;i++)
            {
                if(matrix[i][j]==-1)
                {
                    matrix[i][j]=maxcount;
                }
            }
        }
        return matrix;
        
    }
}
class Solution {
    public boolean canMakeSquare(char[][] grid) {
        boolean ans=false;
        for(int i=0;i<=1;i++)
        {
            
            for(int j=0;j<=1;j++)
            {
            int white=0;
            int black=0;
               if(grid[i][j]=='W')
               {
                white++;
               }
               else{
                black++;
               }
               if(grid[i][j+1]=='W')
               {
                white++;
               }
               else{
                black++;
               }
               if(grid[i+1][j]=='W')
               {
                white++;
               }
               else{
                black++;
               }
               if(grid[i+1][j+1]=='W')
               {
                white++;
               }
               else{
                black++;
               }
                if(Math.max(white,black)>=3)
            {
                ans=true;
                break;
            }
            }
            
        }
        return ans;
    }
}
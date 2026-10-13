class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n=mat.length;
        int[] ans=new int[2];
        int maxonecount=0;
        for(int i=0;i<mat.length;i++)
        {
            int onecount=0;
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==1)
                {
                   onecount++;
                }
                if(onecount>maxonecount)
                {
                    maxonecount=onecount;
                    ans[0]=i;
                    ans[1]=maxonecount;
                }

            }
        }
        return ans;
        
    }
}
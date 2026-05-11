class Solution {
    public int[] shuffle(int[] nums, int n) {
        int n1 = nums.length;
        int[] res = new int[n1];
        int xlen = n1/2;
        int ylen = n1-xlen;
        int[] x = new int[xlen];
        int[] y = new int[ylen];
        for(int i =0;i<xlen;i++)
        {
            x[i]=nums[i];
        }
        for(int i =0;i<ylen;i++)
        {
            y[i]=nums[i+ylen];
        }
        int j =xlen;
        for(int i =0;i<n1;i+=2)
        {
            res[i] = x[n1-xlen-j];
            if(j!=0)

            j--;
        }
        int j1 =ylen;
        for(int i =1;i<n1;i+=2)
        {
            res[i]=y[n1-ylen-j1];
            j1--;
        }
        return res;


        
        
    }
}
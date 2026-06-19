class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] ans = new int[n+1];
        int n1=ans.length;
        ans[0]=0;
        for(int i =1;i<n+1;i++)
        {
            ans[i]=gain[i-1]+ans[i-1];
        }
        int max=ans[0];
        for(int j =1;j<n1;j++)
        {
            if(ans[j]>max)
            {
                max=ans[j];
            }
        }
        return max;

        
    }
}
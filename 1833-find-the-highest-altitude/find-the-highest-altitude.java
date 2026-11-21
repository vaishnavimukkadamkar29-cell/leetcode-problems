class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int prefixsum=0;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            prefixsum+=gain[i];
            ans=Math.max(prefixsum,ans);
        }
        return ans;
    }
}
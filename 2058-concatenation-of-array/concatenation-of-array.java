class Solution {
    public int[] getConcatenation(int[] nums) {
        int n =nums.length;
        int anslen=2*n;
        int[] ans = new int[anslen];
        for(int i =0;i<n;i++)
        {
            ans[i]=nums[i];
        }
        for(int i =0;i<n;i++)
        {
            ans[i+n]=nums[i];
        }
        return ans;
    }
}
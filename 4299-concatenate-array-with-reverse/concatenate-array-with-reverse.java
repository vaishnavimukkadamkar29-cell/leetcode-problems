class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int anslen=2 * n;
        int[] ans= new int[anslen];
        for(int i =0;i<n;i++)
        {
            ans[i]=nums[i];
        }
        for(int i =n;i<anslen;i++)
        {
            ans[i]=nums[anslen-i-1];
        }
        return ans;
    }
}
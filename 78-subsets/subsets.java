class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
         backtrack(0,nums,current, ans);
         return ans;

        
    }
    void backtrack(int index,int[] nums,List<Integer> current,List<List<Integer>> ans )
    {
        if(index==nums.length)
        {
            ans.add(new ArrayList<Integer> (current));
            return;
        }
        current.add(nums[index]);
        backtrack(index+1,nums,current,ans);
        current.remove(current.size()-1);
        backtrack(index+1,nums,current,ans);

    }
}
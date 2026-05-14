class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = Arrays.stream(nums).max().getAsInt();
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums)
        {
            set.add(num);
        }
        for(int i =1;i<n;i++)
        {
            if(!set.contains(i))
            {
                return false;
            }
        }
        if(n!=max+1)
        {
            return false;
        }
        if(nums[n-1]!=nums[n-2])
        {
            return false;
        }
        if(nums[0]!=1)
        {
            return false;
        }
        return true;

        
    }
}
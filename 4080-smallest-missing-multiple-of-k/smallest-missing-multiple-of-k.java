class Solution {
    public int missingMultiple(int[] nums, int k) {
       HashSet<Integer> numsSet = new HashSet<>();
       int ans=0;
       for(int num:nums)
       {
        numsSet.add(num);
       }
       if(!numsSet.contains(k))
       {
        ans= k;
       }
       else{
       for(int i=k;i<Integer.MAX_VALUE;i+=k)
       {
        if(!numsSet.contains(i))
        {
            ans=i;
            break;
        }
       }
       }

        return ans;
       

    }
}
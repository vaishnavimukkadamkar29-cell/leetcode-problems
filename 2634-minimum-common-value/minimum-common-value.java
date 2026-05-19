class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int n1 = nums2.length;
        int ans = nums2[n1-1];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums1)
        {
        map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums2)
        {
            if(map.containsKey(num))
            {
                ans=Math.min(ans,num);
                return ans;
            }
        }
        
        return -1;
    }
}
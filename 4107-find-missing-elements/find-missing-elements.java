class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list=new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int min=nums[0];
        int max=nums[0];
        for(int num:nums)
        {
            if(num<min){
                min=num;
            }
            if(num>max)
            {
                max=num;
            }
            set.add(num);
        }
        for(int i =min;i<=max;i++)
        {
            if(!set.contains(i))
            {
                list.add(i);

            }
        }
        return list;
        
    }
}
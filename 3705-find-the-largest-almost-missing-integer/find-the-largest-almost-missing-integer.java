class Solution {
    public int largestInteger(int[] nums, int k) {
        int n =nums.length;
        int max=-1;
         HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(k==n)
        {
            for(int i =0;i<n;i++)
            {
                max=Math.max(max,nums[i]);
            }
        }
       
        else if(k==1)
        {
            for(int key:map.keySet())
            {
                if(map.get(key)==1)
                {
                    max=Math.max(max,key);
                }
            }
        }
        else {
            int num1 = nums[0];
            int num2 = nums[n-1];
            
            // 1. Check if num1 repeats anywhere else in the array
            boolean num1Repeats = false;
            for (int i = 1; i < n; i++) {
                if (nums[i] == num1) {
                    num1Repeats = true;
                    break;
                }
            }
            
            // 2. Check if num2 repeats anywhere else in the array
            boolean num2Repeats = false;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == num2) {
                    num2Repeats = true;
                    break;
                }
            }
            
            // 3. Pick the maximum valid value based on whether they repeated
            if (!num1Repeats) {
                max = Math.max(max, num1);
            }
            if (!num2Repeats) {
                max = Math.max(max, num2);
            }
        }

        return max;

    }
}
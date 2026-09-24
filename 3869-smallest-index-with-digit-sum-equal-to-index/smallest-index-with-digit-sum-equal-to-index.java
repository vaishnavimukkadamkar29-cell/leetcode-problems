class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        for(int i =0;i<n;i++)
        {
            if(nums[i]<10)
            {
                if(nums[i]==i)
                {
                    return i;
                }
            }
            else{
                int temp=nums[i];
                int sum=0;
                while(temp!=0)
                {
                    int digit=temp%10;
                    sum=sum+digit;
                    temp=temp/10;
                }
                if(sum==i)
                {
                    return i;
                }
            }
        }
        return -1;
    }
}
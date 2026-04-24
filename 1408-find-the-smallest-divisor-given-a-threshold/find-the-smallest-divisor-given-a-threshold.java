import java.lang.Math;
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
       int low=1;int high=Arrays.stream(nums).max().getAsInt();
       while(low<=high)
       {
        int mid=(low+high)/2;
        int sum=sumofD(nums,mid);
        if(sum<=threshold)
        {
            high=mid-1;
        }
        else{
            low=mid+1;
        }

       }
       return low;
    }
    public int sumofD(int[] nums,int d)
    {
        int sum=0;
        for(int num:nums)
        {
            sum+=Math.ceilDiv(num,d);
        }
        return sum;
    }
}
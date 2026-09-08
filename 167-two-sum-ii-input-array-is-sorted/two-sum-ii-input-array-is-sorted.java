class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int[] ans=new int[2];
        boolean found=false;
       int left=0;
       int right=n-1;
       while(!found)
       {
        if(numbers[left]+numbers[right]==target)
        {
            ans[0]=left+1;
            ans[1]=right+1;
            found=true;
        }
        else if(numbers[left]+numbers[right]>target)
        {
            right--;
        }
        else{
            left++;
        }
       }
       return ans;
        
    }
}
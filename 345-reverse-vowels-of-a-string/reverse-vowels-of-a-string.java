class Solution {
    public String reverseVowels(String s) {
        int n=s.length();
        char[] arr= s.toCharArray();
        int left=0;
        int right=arr.length-1;
        while(left<right)
        {
            while(left<right && !isvowel(arr[left]))
            {
                left++;
            }
            while(left<right && !isvowel(arr[right]))
            {
                right--;
            }
            if(left<right)
            {
                char temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }
        return new String(arr);
        
    }
    private boolean isvowel(char c)
    {
        return "aeiouAEIOU".indexOf(c) !=-1;
    }
}
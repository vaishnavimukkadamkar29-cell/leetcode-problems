class Solution {
    public String reverseStr(String s, int k) {
        char[] arr=s.toCharArray();
        int n=s.length();
        if(n==1)
        {
            return s;
        }
        for(int i =0;i<s.length()-1;i+=2*k)
        {
            int left=i;
            int right=Math.min(i+k-1,n-1);
            while(left<right)
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
}
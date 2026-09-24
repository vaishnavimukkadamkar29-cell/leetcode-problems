class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        reverse(s,0,n-1);
        

        
    }
    public void reverse(char[] s,int left,int right)
    {
        if(left>right)
        {
            return;
        }
        char temp=s[left];
        s[left]=s[right];
        s[right]=temp;
        left=left+1;
        right=right-1;
        reverse(s,left,right);

    }
}
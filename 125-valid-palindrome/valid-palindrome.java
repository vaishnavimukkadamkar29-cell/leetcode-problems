class Solution {
    public boolean isPalindrome(String s) {
       int n = s.length();
       int left=0;
       int right=n-1;
       while(left<right)
       {
        char c1 = s.charAt(left);
        char c2 = s.charAt(right);
        if(!Character.isLetterOrDigit(c1))
        {
            left++;
            continue;
        }
        if(!Character.isLetterOrDigit(c2))
        {
            right--;
            continue;

        }
        if(Character.toLowerCase(c1)!=Character.toLowerCase(c2))
        {
            return false;
        }
        left++;
        right--;
       }
       return true;
        
    }
}
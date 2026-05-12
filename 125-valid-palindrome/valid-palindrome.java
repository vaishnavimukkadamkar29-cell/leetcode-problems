class Solution {
    public boolean isPalindrome(String s) {
        String s1=s.replaceAll("[^a-zA-Z0-9]","");
        s1=s1.toLowerCase();
        int n =s1.length();
        int left=0;
        int right=n-1;
        boolean ans=true;
        while(left<right)
        {
            if(s1.charAt(left)!=s1.charAt(right))
            {
                ans=false;
                break;
            }
            else{
                left++;
                right--;
            }
        }
        return ans;

        
    }
}
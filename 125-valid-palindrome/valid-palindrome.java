class Solution {
    public boolean isPalindrome(String s) {
      String valid=s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
      int left=0;
      int right=valid.length()-1;
      while(left<right)
      {
        if(valid.charAt(left)!=valid.charAt(right))
        {
            return false;
            
        }
        left++;
        right--;
      }
      return true;
    }
}
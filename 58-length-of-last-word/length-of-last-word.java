class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        String[] arr = s.split(" +");
        String last=arr[arr.length-1];
        int ans=last.length();
        return ans;


        
    }
}
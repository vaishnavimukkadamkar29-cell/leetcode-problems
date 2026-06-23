class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(int i =0;i<s.length();i++)
        {
            count[s.charAt(i)-'a']++;
        }
        for(int j =0;j<s.length();j++)
        {
            char currentchar=s.charAt(j);
            if(count[currentchar-'a']==1)
            {
                return j;
            }
        }
        return -1;
        
    }
}
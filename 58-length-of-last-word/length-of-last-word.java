class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int lastSpaceindex=s.lastIndexOf(' ');
        String last;
        if(lastSpaceindex==-1)
        {
            last=s;
        }
        else{
            last=s.substring(lastSpaceindex+1);
        }
return last.length();
        
    }
}
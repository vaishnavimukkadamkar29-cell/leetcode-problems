class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String newString1=" ";
        String newString2=" ";
        for(int i =0;i<word1.length;i++)
        {
            newString1+=word1[i];
        }
        for(int i=0;i<word2.length;i++)
        {
            newString2+=word2[i];
        }
        if(newString1.equals(newString2))
        {
            return true;
        }
        return false;
        
    }
}
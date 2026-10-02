class Solution {
    public int maxVowels(String s, int k) {
        int n =s.length();
        int currentVowel=0;
        for(int i =0;i<k;i++)
        {
            if(isVowel(s.charAt(i)))
            {
                currentVowel++;
            }
        }
        int maxVowel=currentVowel;
        for(int i =k;i<n;i++)
        {
            if(isVowel(s.charAt(i-k)))
            {
                currentVowel--;
            }
            if(isVowel(s.charAt(i)))
            {
                currentVowel++;
            }
            maxVowel=Math.max(maxVowel,currentVowel);

        }
        return maxVowel;
        
    }
    public boolean isVowel(char c)
    {
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
        {
            return true;
        }
        return false;
    }
}
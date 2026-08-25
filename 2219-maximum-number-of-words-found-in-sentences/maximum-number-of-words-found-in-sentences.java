class Solution {
    public int mostWordsFound(String[] sentences) {
        int max=0;
        int n=sentences.length;
       for(String sentence:sentences)
       {
        int words=1;
        for(int i =0;i<sentence.length();i++)
        {
            if(sentence.charAt(i)==' ')
            {
                words++;
            }
            max=Math.max(max,words);
       }
    }
           return max;

}
}
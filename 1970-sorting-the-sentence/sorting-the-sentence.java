class Solution {
    public String sortSentence(String s) {
       String[] words=s.split(" ");
       String[] ans=new String[words.length];
       StringBuilder result=new StringBuilder();
       for(String word:words)
       {
        int pos=word.charAt(word.length()-1)-'1';
        ans[pos]=word.substring(0,word.length()-1);
       }
       for(int i =0;i<ans.length;i++)
       {
        result.append(ans[i]);
        if(i!=ans.length-1)
        {
            result.append(" ");
        }
       }
       return result.toString();

        
    }
}
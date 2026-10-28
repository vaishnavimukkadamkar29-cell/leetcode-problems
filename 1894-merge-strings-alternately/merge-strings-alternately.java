class Solution {
    public String mergeAlternately(String word1, String word2) {
       StringBuilder sb= new StringBuilder();
      int n1=word1.length();
      int n2=word2.length();
      int min=Math.min(n1,n2);
      int max=Math.max(n1,n2);
      String minlen="";
      String maxlen="";
      if(n1>n2)
      {
        maxlen=word1;
        minlen=word2;
      }
      else{
        maxlen=word2;
        minlen=word1;
      }
      for(int i =0;i<min;i++)
      {
        sb.append(word1.charAt(i));
        sb.append(word2.charAt(i));
      }
      if(sb.toString().length()!=n1+n2)
      {
        for(int i=min;i<max;i++)
        {
            sb.append(maxlen.charAt(i));
        }
      }

        return sb.toString();
        
    }
}
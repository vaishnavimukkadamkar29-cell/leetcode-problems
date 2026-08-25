class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result=new StringBuilder();
       int i =0;
       int j =0;
       int n1=word1.length();
       int n2=word2.length();
       int maxlen=Math.max(n1,n2);
       int minlen=Math.min(n1,n2);
       while(i<n1 && j<n2)
       {
        result.append(word1.charAt(i));
        result.append(word2.charAt(j));
        i++;
        j++;
       }
       while(i<n1)
       {
        result.append(word1.charAt(i));
        i++;
       }
       while(j<n2)
       {
        result.append(word2.charAt(j));
        j++;
       }
       return result.toString();
    }
}
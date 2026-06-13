class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder(); 
        Map<Integer,Character> reversemap = new HashMap<>();
        int count = 0;
        for(char ch ='z';ch>='a';ch--)
        {
            reversemap.put(count,ch);
            count++;
        }
        int n = words.length;
        Map<Character,Integer> weightmap=new HashMap<>();
        int i =0;
        for(char ch='a';ch<='z';ch++)
        {
            weightmap.put(ch,weights[i]);
            i++;
        }
        
       for(int j =0;j<n;j++)
       {
        int sum =0;
        String currentWord=words[j];
        for(int k =0;k<currentWord.length();k++){
            char currentChar=currentWord.charAt(k);
        if(weightmap.containsKey(currentChar))
        {
            sum+=weightmap.get(currentChar);
         }
        }
        int ansvar=sum%26;
        if(reversemap.containsKey(ansvar))
        {
            ans.append(reversemap.get(ansvar));
        }
        
       }

      return ans.toString();
        
    }
}
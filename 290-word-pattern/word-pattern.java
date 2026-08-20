class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] ch=pattern.toCharArray();
        String[] words =s.split(" ");
        HashMap<Character,String> map=new HashMap<>();
        HashSet<String> usedWords=new HashSet<>();
        if(ch.length!=words.length)
        {
            return false;
        }
        for(int i =0;i<ch.length;i++)
        {
            char c=ch[i];
            String w=words[i];
            if(map.containsKey(c))
            {
                if(!map.get(c).equals(w))
                {
                    return false;
                }
            }
                else{
                    if(usedWords.contains(w))
                    {
                        return false;
                    }
                map.put(c,w);
                usedWords.add(w);
                }
            
           
        }
        return true;
        
    }
}
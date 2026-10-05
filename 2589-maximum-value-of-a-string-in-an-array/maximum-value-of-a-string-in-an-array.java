class Solution {
    public int maximumValue(String[] strs) {
       int max=0;
       int n= strs.length;
       for(String s:strs)
       {
          boolean hasletter=false;
          for(char c:s.toCharArray())
          {
             if(Character.isLetter(c))
             {
                hasletter=true;
                break;
             }
          }
          int currentmax=hasletter ? s.length() : Integer.parseInt(s);
            if(currentmax>max)
                {
                    max=currentmax;
                }
       }
      
       return max;
        
    }
    
}
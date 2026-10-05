class Solution {
    public int maximumValue(String[] strs) {
        int n=strs.length;
        int max=0;
        for(int i=0;i<n;i++)
        {
            int tempmax=0;
            String temp=strs[i];
            if(Containsboth(temp))
            {
                tempmax=temp.length();
            }
            else if(onlyletters(temp))
            {
                tempmax=temp.length();
            }
            else if(onlydig(temp)){
                tempmax=Integer.parseInt(temp);
            }
            
            max=Math.max(max,tempmax);

           
        }
        return max;

        
    }
    public boolean Containsboth(String s)
    {
        boolean hasletter = false;
        boolean hasdigit=false;
        for(char c:s.toCharArray())
        {
            if(Character.isLetter(c))
            {
                hasletter=true;
            }
            else if(Character.isDigit(c))
            {
                hasdigit=true;
            }
            if(hasletter && hasdigit)
            {
                return true;
            }
        }
        return hasletter && hasdigit;
    }
    boolean onlylet=false;
    public boolean onlyletters(String s)
    {
        for(char c:s.toCharArray())
        {
            if(Character.isLetter(c))
            {
                onlylet=true;
            }
            else{
                onlylet=false;
            }
        }
        return onlylet;

    }
    boolean onlydig=false;
    public boolean onlydig(String s)
    {
        for(char c:s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                onlydig=true;
            }
        }
        return onlydig;
        
    }
    
}